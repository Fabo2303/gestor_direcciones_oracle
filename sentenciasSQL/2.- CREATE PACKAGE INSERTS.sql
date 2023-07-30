create or replace PACKAGE inserts AS
    PROCEDURE insertar_video(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    );

	PROCEDURE insertar_imagen(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    );

	PROCEDURE insertar_pdf(
		p_titulo VARCHAR2,
		p_descripcion CLOB,
		p_id_proy NUMBER,
		p_url VARCHAR2,
		p_visualizacion NUMBER
    );
END inserts;
