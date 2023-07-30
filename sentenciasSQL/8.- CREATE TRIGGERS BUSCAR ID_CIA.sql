--Trigger para encontrar el id_cia

CREATE OR REPLACE TRIGGER trg_video_id_cia
BEFORE INSERT ON VIDEO
FOR EACH ROW
DECLARE
    v_id_cia PROYECTO.codcia%TYPE;
BEGIN
    -- Buscar el id_cia correspondiente al id_proy en la tabla PROYECTO
    SELECT codcia INTO v_id_cia
    FROM PROYECTO
    WHERE codpyto = :NEW.ID_PROY;

    -- Asignar el id_cia encontrado a la columna id_cia de la tabla VIDEO
    :NEW.id_cia := v_id_cia;
END;


CREATE OR REPLACE TRIGGER trg_imagen_id_cia
BEFORE INSERT ON IMAGEN
FOR EACH ROW
DECLARE
    v_id_cia PROYECTO.codcia%TYPE;
BEGIN
    -- Buscar el id_cia correspondiente al id_proy en la tabla PROYECTO
    SELECT codcia INTO v_id_cia
    FROM PROYECTO
    WHERE codpyto = :NEW.ID_PROY;

    -- Asignar el id_cia encontrado a la columna id_cia de la tabla IMAGEN
    :NEW.id_cia := v_id_cia;
END;


CREATE OR REPLACE TRIGGER trg_pdf_id_cia
BEFORE INSERT ON PDF
FOR EACH ROW
DECLARE
    v_id_cia PROYECTO.codcia%TYPE;
BEGIN
    -- Buscar el id_cia correspondiente al id_proy en la tabla PROYECTO
    SELECT codcia INTO v_id_cia
    FROM PROYECTO
    WHERE codpyto = :NEW.ID_PROY;

    -- Asignar el id_cia encontrado a la columna id_cia de la tabla PDF
    :NEW.ID_CIA := v_id_cia;
END;
