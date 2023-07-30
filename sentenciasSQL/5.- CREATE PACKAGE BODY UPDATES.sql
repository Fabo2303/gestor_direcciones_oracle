CREATE OR REPLACE PACKAGE BODY Updates AS
    PROCEDURE update_video(
        p_id NUMBER,
        p_titulo VARCHAR2 DEFAULT NULL,
        p_descripcion CLOB DEFAULT NULL,
        p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
        p_url VARCHAR2 DEFAULT NULL,
        p_visualizacion NUMBER DEFAULT NULL
    ) IS
        v_sql VARCHAR2(1000);
    BEGIN
        v_sql := 'UPDATE VIDEO SET';

        IF p_titulo IS NOT NULL THEN
          v_sql := v_sql || ' titulo = ''' || p_titulo || ''',';
        END IF;

        IF p_descripcion IS NOT NULL THEN
          v_sql := v_sql || ' descripcion = ''' || p_descripcion || ''',';
        END IF;

        IF p_id_proy IS NOT NULL THEN
          v_sql := v_sql || ' id_proy = ' || p_id_proy || ',';
        END IF;

        IF p_id_cia IS NOT NULL THEN
          v_sql := v_sql || ' id_cia = ' || p_id_cia || ',';
        END IF;

        IF p_url IS NOT NULL THEN
          v_sql := v_sql || ' url = ''' || p_url || ''',';
        END IF;

        IF p_visualizacion IS NOT NULL THEN
          v_sql := v_sql || ' visualizacion = ' || p_visualizacion || ',';
        END IF;

        -- Eliminar la última coma de la sentencia SQL
        v_sql := RTRIM(v_sql, ',');

        v_sql := v_sql || ' WHERE id = ' || p_id;

        EXECUTE IMMEDIATE v_sql;

        COMMIT;
    END;
    
    PROCEDURE update_imagen(
        p_id NUMBER,
        p_titulo VARCHAR2 DEFAULT NULL,
        p_descripcion CLOB DEFAULT NULL,
        p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
        p_url VARCHAR2 DEFAULT NULL,
        p_visualizacion NUMBER DEFAULT NULL
    ) IS
        v_sql VARCHAR2(1000);
    BEGIN
        v_sql := 'UPDATE IMAGEN SET';

        IF p_titulo IS NOT NULL THEN
          v_sql := v_sql || ' titulo = ''' || p_titulo || ''',';
        END IF;

        IF p_descripcion IS NOT NULL THEN
          v_sql := v_sql || ' descripcion = ''' || p_descripcion || ''',';
        END IF;

        IF p_id_proy IS NOT NULL THEN
          v_sql := v_sql || ' id_proy = ' || p_id_proy || ',';
        END IF;

        IF p_id_cia IS NOT NULL THEN
          v_sql := v_sql || ' id_cia = ' || p_id_cia || ',';
        END IF;

        IF p_url IS NOT NULL THEN
          v_sql := v_sql || ' url = ''' || p_url || ''',';
        END IF;

        IF p_visualizacion IS NOT NULL THEN
          v_sql := v_sql || ' visualizacion = ' || p_visualizacion || ',';
        END IF;

        -- Eliminar la última coma de la sentencia SQL
        v_sql := RTRIM(v_sql, ',');

        v_sql := v_sql || ' WHERE id = ' || p_id;

        EXECUTE IMMEDIATE v_sql;

        COMMIT;
    END;
    
    PROCEDURE update_pdf(
        p_id NUMBER,
        p_titulo VARCHAR2 DEFAULT NULL,
        p_descripcion CLOB DEFAULT NULL,
        p_id_proy NUMBER DEFAULT NULL,
        p_id_cia NUMBER DEFAULT NULL,
        p_url VARCHAR2 DEFAULT NULL,
        p_visualizacion NUMBER DEFAULT NULL
    ) IS
        v_sql VARCHAR2(1000);
    BEGIN
        v_sql := 'UPDATE PDF SET';

        IF p_titulo IS NOT NULL THEN
          v_sql := v_sql || ' titulo = ''' || p_titulo || ''',';
        END IF;

        IF p_descripcion IS NOT NULL THEN
          v_sql := v_sql || ' descripcion = ''' || p_descripcion || ''',';
        END IF;

        IF p_id_proy IS NOT NULL THEN
          v_sql := v_sql || ' id_proy = ' || p_id_proy || ',';
        END IF;

        IF p_id_cia IS NOT NULL THEN
          v_sql := v_sql || ' id_cia = ' || p_id_cia || ',';
        END IF;

        IF p_url IS NOT NULL THEN
          v_sql := v_sql || ' url = ''' || p_url || ''',';
        END IF;

        IF p_visualizacion IS NOT NULL THEN
          v_sql := v_sql || ' visualizacion = ' || p_visualizacion || ',';
        END IF;

        -- Eliminar la última coma de la sentencia SQL
        v_sql := RTRIM(v_sql, ',');

        v_sql := v_sql || ' WHERE id = ' || p_id;

        EXECUTE IMMEDIATE v_sql;

        COMMIT;
    END;
END Updates;