create or replace TRIGGER trg_video_id
    BEFORE INSERT ON VIDEO
    FOR EACH ROW
    BEGIN
        SELECT seq_video_id.NEXTVAL INTO :NEW.ID FROM dual;
    END;

create or replace TRIGGER trg_imagen_id
    BEFORE INSERT ON IMAGEN
    FOR EACH ROW
    BEGIN
        SELECT seq_imagen_id.NEXTVAL INTO :NEW.ID FROM dual;
    END;
    
create or replace  TRIGGER trg_pdf_id
    BEFORE INSERT ON PDF
    FOR EACH ROW
    BEGIN
        SELECT seq_pdf_id.NEXTVAL INTO :NEW.ID FROM dual;
    END;


drop TRIGGER trg_video_id;
drop TRIGGER trg_imagen_id;
drop TRIGGER trg_pdf_id;