CREATE OR REPLACE PACKAGE updates AS
    PROCEDURE update_video(
		p_id NUMBER,
		p_titulo VARCHAR2 DEFAULT NULL,
		p_descripcion CLOB DEFAULT NULL,
		p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
		p_url VARCHAR2 DEFAULT NULL,
		p_visualizacion NUMBER DEFAULT NULL
    );
    
    PROCEDURE update_imagen(
		p_id NUMBER,
		p_titulo VARCHAR2 DEFAULT NULL,
		p_descripcion CLOB DEFAULT NULL,
		p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
		p_url VARCHAR2 DEFAULT NULL,
		p_visualizacion NUMBER DEFAULT NULL
    );
    
    PROCEDURE update_pdf(
		p_id NUMBER,
		p_titulo VARCHAR2 DEFAULT NULL,
		p_descripcion CLOB DEFAULT NULL,
		p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
		p_url VARCHAR2 DEFAULT NULL,
		p_visualizacion NUMBER DEFAULT NULL
    );
END Updates;

