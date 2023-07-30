CREATE VIEW video_todo AS
SELECT *
FROM VIDEO;

CREATE VIEW video_visual_cero AS
SELECT *
FROM VIDEO
WHERE visualizacion = 0;


CREATE VIEW video_visual_uno AS
SELECT *
FROM VIDEO
WHERE visualizacion = 1;

CREATE VIEW imagen_todo AS
SELECT *
FROM IMAGEN;

CREATE VIEW imagen_visual_cero AS
SELECT *
FROM IMAGEN
WHERE visualizacion = 0;

CREATE VIEW imagen_visual_uno AS
SELECT *
FROM IMAGEN
WHERE visualizacion = 1;

CREATE VIEW pdf_todo AS
SELECT *
FROM PDF;

CREATE VIEW pdf_visual_cero AS
SELECT *
FROM PDF
WHERE visualizacion = 0;

CREATE VIEW pdf_visual_uno AS
SELECT *
FROM PDF
WHERE visualizacion = 1;