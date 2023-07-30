-- Creación de la tabla VIDEO
CREATE TABLE VIDEO (
    ID NUMBER(6) PRIMARY KEY,
    titulo VARCHAR2(50),
    descripcion CLOB,
    id_proy NUMBER(6),
    id_cia NUMBER(6),
    url VARCHAR2(100),
    visualizacion NUMBER(1) CHECK (visualizacion IN (0, 1))
);

-- Creación de la tabla IMAGEN
CREATE TABLE IMAGEN (
    ID NUMBER(6) PRIMARY KEY,
    titulo VARCHAR2(50),
    descripcion CLOB,
    id_proy NUMBER(6),
    id_cia NUMBER(6),
    url VARCHAR2(100),
    visualizacion NUMBER(1) CHECK (visualizacion IN (0, 1))
);

-- Creación de la tabla PDF
CREATE TABLE PDF (
    ID NUMBER(6) PRIMARY KEY,
    titulo VARCHAR2(50),
    descripcion CLOB,
    id_proy NUMBER(6),
    id_cia NUMBER(6),
    url VARCHAR2(100),
    visualizacion NUMBER(1) CHECK (visualizacion IN (0, 1))
);

CREATE TABLE AUDITORIA (
    ID NUMBER(6),
    TABLA_AFECTADA VARCHAR2(10),
    FECHA_ACCION DATE,
    ACCION VARCHAR2(6)

);


--INICIALIZAR LAS FK
ALTER TABLE VIDEO
ADD FOREIGN KEY (id_cia,id_proy)
REFERENCES PROYECTO(CODCIA, CODPYTO);

ALTER TABLE IMAGEN
ADD FOREIGN KEY (id_cia,id_proy)
REFERENCES PROYECTO(CODCIA, CODPYTO);

ALTER TABLE PDF
ADD FOREIGN KEY (id_cia,id_proy)
REFERENCES PROYECTO(CODCIA, CODPYTO);