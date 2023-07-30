create or replace PACKAGE BODY inserts AS
	PROCEDURE insertar_video(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    ) IS
	BEGIN
		INSERT INTO video(titulo, descripcion, id_proy, url, visualizacion)
		VALUES (p_titulo, p_descripcion, p_id_proy, p_url, p_visualizacion);
	END;

	PROCEDURE insertar_imagen(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    ) IS
	BEGIN
		INSERT INTO imagen(titulo, descripcion, id_proy, url, visualizacion)
		VALUES (p_titulo, p_descripcion, p_id_proy, p_url, p_visualizacion);
	END;

	PROCEDURE insertar_pdf(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    ) IS
	BEGIN
		INSERT INTO pdf(titulo, descripcion, id_proy, url, visualizacion)
		VALUES (p_titulo, p_descripcion, p_id_proy, p_url, p_visualizacion);
	END;
END inserts;