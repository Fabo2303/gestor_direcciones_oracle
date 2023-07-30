CREATE OR REPLACE VIEW proyecto_cod_nombre AS
SELECT codpyto, nompyto
FROM PROYECTO
ORDER BY codpyto;