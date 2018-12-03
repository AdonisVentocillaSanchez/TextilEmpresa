--Creación de triggers
--Creamos una tabla  usuario para poder guardar los usuarios, contraseñas y dni de los
--empleados y jefes para que puedan acceder al sistema segun su tipo.

CREATE TABLE USUARIO
( 
	id_user              int IDENTITY(1,1) PRIMARY KEY,
	dni_user             char(8)  NOT NULL,
	us_user              varchar(50)  NOT NULL ,
	pass_user            varchar(50)  NOT NULL ,
	tipo_user            char(15)  NOT NULL
)
go
	--Trigger para almacenar los datos de la tabla JEFEAREA en USUARIO

	CREATE TRIGGER TR_INSERTARENUSUARIO_JEFE
	ON JEFEAREA 
	FOR INSERT
	AS 
	DECLARE @user varchar(50)
	DECLARE @pass varchar(50)
	DECLARE @dni char(8)

	SELECT @user = i.user_jef FROM inserted i;
	SELECT @pass = i.pass_jef FROM inserted i;
	SELECT @dni = i.dni_jef FROM inserted i;

	INSERT INTO USUARIO(dni_user, us_user, pass_user, tipo_user) 
	VALUES(@dni, @user, @pass, 'ADMINISTRADOR')
	GO

--Trigger para eliminar los datos de la tabla USUARIO si se elimina en JEFEAREA

	CREATE TRIGGER TR_ELIMINARJEFE
	ON JEFEAREA
	FOR DELETE
	AS
	delete us
	 from dbo.USUARIO us
	join deleted d
	on d.dni_jef = us.dni_user
	GO

	--Trigger para almacenar los datos de la tabla EMPLEADO en USUARIO 

	CREATE TRIGGER TR_INSERTARENUSUARIO_EMPLE
	ON EMPLEADO 
	FOR INSERT
	AS 
	DECLARE @user varchar(50)
	DECLARE @pass varchar(50)
	DECLARE @dni char(8)

	SELECT @user = i.user_emp FROM inserted i;
	SELECT @pass = i.pass_emp FROM inserted i;
	SELECT @dni = i.dni_emp FROM inserted i;

	INSERT INTO USUARIO(dni_user, us_user, pass_user, tipo_user) 
	VALUES(@dni, @user, @pass, 'EMPLEADO')
	GO

--Trigger para eliminar los datos de la tabla USUARIO si se elimina en EMPLEADO

	CREATE TRIGGER TR_ELIMINAREMPLE
	ON JEFEAREA
	FOR DELETE
	AS
	delete us
	 from dbo.USUARIO us
	join deleted d
	on d.dni_jef = us.dni_user
	GO


--Creación de procedimientos almacenados
--para validar un usuario en el programa

CREATE PROC SP_LOGIN
@user AS varchar(50),
@pass AS varchar(50)
AS
SELECT u.tipo_user
FROM USUARIO u
WHERE u.us_user=@user AND u.pass_user=@pass
GO

--Para añadir un nuevo cliente

CREATE PROC SP_NUEVOCLIENTE
@dni AS char(8),
@nom AS varchar(50),
@ape AS varchar(50),
@dir AS varchar(50),
@telef AS char(9)
AS
INSERT INTO CLIENTE VALUES(@dni,@nom,@ape,@dir,@telef)
GO

--Para buscar un cliente por DNI, nombre o apellido

CREATE PROC SP_BUSCARCLIENTE
@busq AS varchar(50)
AS
SELECT * FROM CLIENTE
WHERE dni_clie LIKE @busq OR nom_clie LIKE @busq OR ape_clie LIKE @busq
ORDER BY ape_clie ASC
GO

--Para mostrar toda la tabla cliente

CREATE PROC SP_CLIENTE
AS
SELECT * 
FROM CLIENTE
ORDER BY nom_clie ASC
GO

--Para eliminar un cliente

CREATE PROC SP_ELIMINARCLIENTE
@inf AS varchar(50)
AS
DELETE FROM CLIENTE
WHERE dni_clie=@inf
GO


--Creación de un job
--link para hacerlo : https://www.youtube.com/watch?v=Tasc_9zX1kc
--Para crear un backup de toda la base de datos BDCondor todos los lunes semanalmente
USE [msdb]
GO
DECLARE @jobId BINARY(16)
EXEC  msdb.dbo.sp_add_job @job_name=N'CopiaSeguridad_BDCondor', 
		@enabled=1, 
		@notify_level_eventlog=0, 
		@notify_level_email=2, 
		@notify_level_page=2, 
		@delete_level=0, 
		@description=N'Backup semanal', 
		@category_name=N'[Uncategorized (Local)]', 
		@owner_login_name=N'sa', @job_id = @jobId OUTPUT
select @jobId
GO
EXEC msdb.dbo.sp_add_jobserver @job_name=N'CopiaSeguridad_BDCondor', @server_name = N'CLASE'
GO
USE [msdb]
GO
EXEC msdb.dbo.sp_add_jobstep @job_name=N'CopiaSeguridad_BDCondor', @step_name=N'BK_BDCondor', 
		@step_id=1, 
		@cmdexec_success_code=0, 
		@on_success_action=1, 
		@on_fail_action=2, 
		@retry_attempts=0, 
		@retry_interval=0, 
		@os_run_priority=0, @subsystem=N'TSQL', 
		@command=N'BACKUP DATABASE [BDCondor] TO  DISK = N''C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\Backup\BDCondor.bak'' WITH NOFORMAT,
 INIT,  NAME = N''BDCondor-Completa Base de datos Copia de seguridad'', 
 SKIP, NOREWIND, NOUNLOAD,  STATS = 10
GO', 
		@database_name=N'BDCondor', 
		@flags=0
GO
USE [msdb]
GO
EXEC msdb.dbo.sp_update_job @job_name=N'CopiaSeguridad_BDCondor', 
		@enabled=1, 
		@start_step_id=1, 
		@notify_level_eventlog=0, 
		@notify_level_email=2, 
		@notify_level_page=2, 
		@delete_level=0, 
		@description=N'Backup semanal', 
		@category_name=N'[Uncategorized (Local)]', 
		@owner_login_name=N'sa', 
		@notify_email_operator_name=N'', 
		@notify_page_operator_name=N''
GO
USE [msdb]
GO
DECLARE @schedule_id int
EXEC msdb.dbo.sp_add_jobschedule @job_name=N'CopiaSeguridad_BDCondor', @name=N'BK_BDCondor', 
		@enabled=1, 
		@freq_type=8, 
		@freq_interval=3, 
		@freq_subday_type=1, 
		@freq_subday_interval=0, 
		@freq_relative_interval=0, 
		@freq_recurrence_factor=1, 
		@active_start_date=20180716, 
		@active_end_date=99991231, 
		@active_start_time=200000, 
		@active_end_time=235959, @schedule_id = @schedule_id OUTPUT
select @schedule_id
GO
