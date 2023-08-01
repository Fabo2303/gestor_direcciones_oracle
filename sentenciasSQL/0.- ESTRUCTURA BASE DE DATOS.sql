DROP TABLE FLUJOCAJA_DET;
DROP TABLE FLUJOCAJA;
DROP TABLE VTACOMP_PAGODET;
DROP TABLE VTACOMP_PAGOCAB;
DROP TABLE COMP_PAGODET;
DROP TABLE COMP_PAGOCAB;
DROP TABLE DPROY_PARTIDA_MEZCLA;
DROP TABLE PROY_PARTIDA_MEZCLA;
DROP TABLE PROY_PARTIDA;
DROP TABLE VERSION_PRES;
DROP TABLE PROYECTO;
DROP TABLE CLIENTE;
DROP TABLE PARTIDAMEZCLA;
DROP TABLE PARTIDA;
DROP TABLE ELEMENTOS;
DROP TABLE ESTADO;
DROP TABLE TABS;
DROP TABLE EMPRESA_VTA;
DROP TABLE PROVEEDOR;
DROP TABLE EMPLEADO;
DROP TABLE PERSONA;
DROP TABLE CIA;

CREATE TABLE cia (
    codcia   NUMBER(6) NOT NULL,
    descia   VARCHAR2(100 BYTE) NOT NULL,
    descorta VARCHAR2(20 BYTE) NOT NULL,
    vigente  VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cia_pk ON
    cia (
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE cia
    ADD CONSTRAINT cia_pk PRIMARY KEY ( codcia )
        USING INDEX cia_pk;

CREATE TABLE cliente (
    codcia     NUMBER(6) NOT NULL,
    codcliente NUMBER(6) NOT NULL,
    nroruc     VARCHAR2(20 BYTE) NOT NULL,
    vigente    VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX cliente_pk ON
    cliente (
        codcliente
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE cliente
    ADD CONSTRAINT cliente_pk PRIMARY KEY ( codcliente,
                                            codcia )
        USING INDEX cliente_pk;

CREATE TABLE comp_pagocab (
    codcia              NUMBER(6) NOT NULL,
    codproveedor        NUMBER(6) NOT NULL,
    nrocp               VARCHAR2(20 BYTE) NOT NULL,
    codpyto             NUMBER(6) NOT NULL,
    nropago             NUMBER(3),
    tcomppago           VARCHAR2(3 BYTE),
    ecomppago           VARCHAR2(3 BYTE),
    feccp               DATE,
    tmoneda             VARCHAR2(3 BYTE),
    emoneda             VARCHAR2(3 BYTE),
    tipcambio           NUMBER(7, 4),
    impmo               NUMBER(9, 2),
    impnetomn           NUMBER(9, 2),
    impigvmn            NUMBER(9, 2),
    imptotalmn          NUMBER(10, 2),
    fecabono            DATE,
    desabono            VARCHAR2(1000 BYTE),
    semilla             NUMBER(5),
    tabestado           VARCHAR2(3 BYTE),
    codestado           VARCHAR2(3 BYTE),
    proyecto_cia_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX comp_pagocab_pk ON
    comp_pagocab (
        nrocp
    ASC,
        codproveedor
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_pk PRIMARY KEY ( nrocp,
                                                 codproveedor,
                                                 codcia )
        USING INDEX comp_pagocab_pk;

CREATE TABLE comp_pagodet (
    codcia         NUMBER(6) NOT NULL,
    codproveedor   NUMBER(6) NOT NULL,
    nrocp          VARCHAR2(20 BYTE) NOT NULL,
    sec            NUMBER(4) NOT NULL,
    ingegr         VARCHAR2(1 BYTE) NOT NULL,
    codpartida     NUMBER(6) NOT NULL,
    impnetomn      NUMBER(9, 2),
    impigvmn       NUMBER(9, 2),
    imptotalmn     NUMBER(9, 2),
    semilla        NUMBER(5),
    partida_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX comp_pagodet_pk ON
    comp_pagodet (
        sec
    ASC,
        nrocp
    ASC,
        codproveedor
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE comp_pagodet
    ADD CONSTRAINT comp_pagodet_pk PRIMARY KEY ( sec,
                                                 nrocp,
                                                 codproveedor,
                                                 codcia )
        USING INDEX comp_pagodet_pk;

CREATE TABLE dproy_partida_mezcla (
    codcia        NUMBER(6) NOT NULL,
    codpyto       NUMBER(6) NOT NULL,
    ingegr        VARCHAR2(1 BYTE) NOT NULL,
    nroversion    NUMBER(1) NOT NULL,
    codpartida    NUMBER(6) NOT NULL,
    corr          NUMBER(6) NOT NULL,
    sec           NUMBER(4) NOT NULL,
    tdesembolso   VARCHAR2(3 BYTE),
    edesembolso   VARCHAR2(3 BYTE),
    nropago       NUMBER(2),
    tcomppago     VARCHAR2(3 BYTE),
    ecomppago     VARCHAR2(3 BYTE),
    fecdesembolso DATE,
    impdesembneto NUMBER(9, 2),
    impdesembigv  NUMBER(8, 2),
    impdesembtot  NUMBER(9, 2),
    semilla       NUMBER(5)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX dproy_partida_mezcla_pk ON
    dproy_partida_mezcla (
        sec
    ASC,
        corr
    ASC,
        codcia
    ASC,
        nroversion
    ASC,
        codpyto
    ASC,
        ingegr
    ASC,
        codpartida
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE dproy_partida_mezcla
    ADD CONSTRAINT dproy_partida_mezcla_pk PRIMARY KEY ( sec,
                                                         corr,
                                                         codcia,
                                                         nroversion,
                                                         codpyto,
                                                         ingegr,
                                                         codpartida )
        USING INDEX dproy_partida_mezcla_pk;

CREATE TABLE elementos (
    codtab   VARCHAR2(3 BYTE) NOT NULL,
    codelem  VARCHAR2(3 BYTE) NOT NULL,
    denele   VARCHAR2(50 BYTE) NOT NULL,
    dencorta VARCHAR2(10 BYTE) NOT NULL,
    vigente  VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX elementos_pk ON
    elementos (
        codelem
    ASC,
        codtab
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE elementos
    ADD CONSTRAINT elementos_pk PRIMARY KEY ( codelem,
                                              codtab )
        USING INDEX elementos_pk;

CREATE TABLE empleado (
    codcia      NUMBER(6) NOT NULL,
    codempleado NUMBER(6) NOT NULL,
    direcc      VARCHAR2(100 BYTE) NOT NULL,
    celular     VARCHAR2(33 BYTE) NOT NULL,
    hobby       VARCHAR2(2000 BYTE) NOT NULL,
    foto        BLOB,
    fecnac      DATE NOT NULL,
    dni         VARCHAR2(20 BYTE) NOT NULL,
    nrocip      VARCHAR2(10 BYTE) NOT NULL,
    feccipvig   DATE NOT NULL,
    liccond     VARCHAR2(1 BYTE) NOT NULL,
    flgempliea  VARCHAR2(1 BYTE) NOT NULL,
    observac    VARCHAR2(300 BYTE) NOT NULL,
    codcargo    NUMBER(4) NOT NULL,
    email       VARCHAR2(100 BYTE) NOT NULL,
    vigente     VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY
    LOB ( foto ) STORE AS SECUREFILE (
        TABLESPACE users
        STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 BUFFER_POOL DEFAULT )
        CHUNK 8192
        RETENTION
        ENABLE STORAGE IN ROW
        NOCACHE LOGGING
    );

COMMENT ON TABLE empleado IS
    'Empleado de la Empresa/Consorcio y del Cliente';

COMMENT ON COLUMN empleado.liccond IS
    '1: Si tiene';

COMMENT ON COLUMN empleado.flgempliea IS
    '1: Empleado de la Empresa Consorcio
2: Empleado del Cliente
3: Empleado de ambos';

COMMENT ON COLUMN empleado.vigente IS
    'Vigente 1';

CREATE UNIQUE INDEX empleado_pk ON
    empleado (
        codempleado
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_pk PRIMARY KEY ( codempleado,
                                             codcia )
        USING INDEX empleado_pk;

CREATE TABLE empresa_vta (
    codcia          NUMBER(6) NOT NULL,
    ciacontrata     NUMBER(6) NOT NULL,
    nroruc          VARCHAR2(20 BYTE) NOT NULL,
    flgempconsorcio VARCHAR2(1 BYTE) NOT NULL,
    fecini          DATE NOT NULL,
    fecfin          DATE NOT NULL,
    codempresa      NUMBER(6) NOT NULL,
    observac        VARCHAR2(2000 BYTE) NOT NULL,
    vigente         VARCHAR2(1 BYTE) NOT NULL,
    persona_codcia  NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

COMMENT ON COLUMN empresa_vta.ciacontrata IS
    '- Empresa o Consorcio';

COMMENT ON COLUMN empresa_vta.flgempconsorcio IS
    '0: Empresa Devenco
1: Consorcio';

CREATE UNIQUE INDEX empresa_pk ON
    empresa_vta (
        ciacontrata
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE empresa_vta
    ADD CONSTRAINT empresa_pk PRIMARY KEY ( ciacontrata,
                                            codcia )
        USING INDEX empresa_pk;

CREATE TABLE estado (
    tabestado VARCHAR2(3 BYTE) NOT NULL,
    codestado VARCHAR2(3 BYTE) NOT NULL,
    desestado VARCHAR2(40 BYTE) NOT NULL,
    descorta  VARCHAR2(10 BYTE) NOT NULL,
    vigente   VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX estado_pk ON
    estado (
        codestado
    ASC,
        tabestado
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE estado
    ADD CONSTRAINT estado_pk PRIMARY KEY ( codestado,
                                           tabestado )
        USING INDEX estado_pk;

CREATE TABLE flujocaja (
    codcia              NUMBER(6) NOT NULL,
    codpyto             NUMBER(6) NOT NULL,
    ingegr              VARCHAR2(1 BYTE) NOT NULL,
    tipo                VARCHAR2(1 BYTE) NOT NULL,
    codpartida          NUMBER(6) NOT NULL,
    nivel               NUMBER(1) NOT NULL,
    orden               NUMBER(5) NOT NULL,
    desconcepto         VARCHAR2(30 BYTE) NOT NULL,
    desconceptocorto    VARCHAR2(10 BYTE) NOT NULL,
    semilla             NUMBER(5) NOT NULL,
    raiz                NUMBER(5) NOT NULL,
    tabestado           VARCHAR2(3 BYTE),
    codestado           VARCHAR2(3 BYTE),
    vigente             VARCHAR2(1 BYTE) NOT NULL,
    proyecto_cia_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX flujocaja_pk ON
    flujocaja (
        tipo
    ASC,
        codcia
    ASC,
        ingegr
    ASC,
        codpartida
    ASC,
        codpyto
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE flujocaja
    ADD CONSTRAINT flujocaja_pk PRIMARY KEY ( tipo,
                                              codcia,
                                              ingegr,
                                              codpartida,
                                              codpyto )
        USING INDEX flujocaja_pk;

CREATE TABLE flujocaja_det (
    anno        NUMBER(4) NOT NULL,
    codcia      NUMBER(6) NOT NULL,
    codpyto     NUMBER(6) NOT NULL,
    ingegr      VARCHAR2(1 BYTE) NOT NULL,
    tipo        VARCHAR2(1 BYTE) NOT NULL,
    codpartida  NUMBER(6) NOT NULL,
    orden       NUMBER(5) NOT NULL,
    impini      NUMBER(12, 2),
    imprealini  NUMBER(12, 2),
    impene      NUMBER(12, 2),
    imprealene  NUMBER(12, 2),
    impfeb      NUMBER(12, 2),
    imprealfeb  NUMBER(12, 2),
    impmar      NUMBER(12, 2),
    imprealmar  NUMBER(12, 2),
    impabr      NUMBER(12, 2),
    imprealabr  NUMBER(12, 2),
    impmay      NUMBER(12, 2),
    imprealmay  NUMBER(12, 2),
    impjun      NUMBER(12, 2),
    imprealjun  NUMBER(12, 2),
    impjul      NUMBER(12, 2),
    imprealjul  NUMBER(12, 2),
    impago      NUMBER(12, 2),
    imprealago  NUMBER(12, 2),
    impset      NUMBER(12, 2),
    imprealset  NUMBER(12, 2),
    impoct      NUMBER(12, 2),
    imprealoct  NUMBER(12, 2),
    impnov      NUMBER(12, 2),
    imprealnov  NUMBER(12, 2),
    impdic      NUMBER(12, 2),
    imprealdic  NUMBER(12, 2),
    impacum     NUMBER(12, 2),
    imprealacum NUMBER(12, 2)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX flujocaja_det_pk ON
    flujocaja_det (
        anno
    ASC,
        codpartida
    ASC,
        tipo
    ASC,
        ingegr
    ASC,
        codpyto
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE flujocaja_det
    ADD CONSTRAINT flujocaja_det_pk PRIMARY KEY ( anno,
                                                  codpartida,
                                                  tipo,
                                                  ingegr,
                                                  codpyto,
                                                  codcia )
        USING INDEX flujocaja_det_pk;

CREATE TABLE partida (
    codcia             NUMBER(6) NOT NULL,
    ingegr             VARCHAR2(1 BYTE) NOT NULL,
    codpartida         NUMBER(6) NOT NULL,
    codpartidas        VARCHAR2(12 BYTE) NOT NULL,
    despartida         VARCHAR2(30 BYTE) NOT NULL,
    flgcc              VARCHAR2(1 BYTE) NOT NULL,
    nivel              NUMBER(2) NOT NULL,
    tunimed            VARCHAR2(3 BYTE) NOT NULL,
    eunimed            VARCHAR2(3 BYTE) NOT NULL,
    semilla            NUMBER(5) NOT NULL,
    vigente            VARCHAR2(1 BYTE) NOT NULL,
    empresa_codpersona NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

COMMENT ON COLUMN partida.ingegr IS
    'I:Ingreso

E: Egreso';

COMMENT ON COLUMN partida.codpartidas IS
    'Formato del codigo
xxx.xxx.xxxx';

COMMENT ON COLUMN partida.flgcc IS
    '1: Codigo de la primera version
2: Codigo de la segunda version';

COMMENT ON COLUMN partida.empresa_codpersona IS
    '- Empresa o Consorcio';

CREATE UNIQUE INDEX partida_pk ON
    partida (
        codcia
    ASC,
        ingegr
    ASC,
        codpartida
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE partida
    ADD CONSTRAINT partida_pk PRIMARY KEY ( codcia,
                                            ingegr,
                                            codpartida )
        USING INDEX partida_pk;

CREATE TABLE partidamezcla (
    codcia         NUMBER(6) NOT NULL,
    ingegr         VARCHAR2(1 BYTE) NOT NULL,
    codpartida     NUMBER(6) NOT NULL,
    corr           NUMBER(6) NOT NULL,
    padcodpartida  NUMBER(6) NOT NULL,
    tunimed        VARCHAR2(3 BYTE) NOT NULL,
    eunimed        VARCHAR2(3 BYTE) NOT NULL,
    costounit      NUMBER(9, 2) NOT NULL,
    nivel          NUMBER(5) NOT NULL,
    orden          NUMBER(5) NOT NULL,
    vigente        VARCHAR2(1 BYTE) NOT NULL,
    partida_codcia NUMBER(6),
    partida_ingegr VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX partidamezcla_pk ON
    partidamezcla (
        corr
    ASC,
        codcia
    ASC,
        ingegr
    ASC,
        codpartida
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE partidamezcla
    ADD CONSTRAINT partidamezcla_pk PRIMARY KEY ( corr,
                                                  codcia,
                                                  ingegr,
                                                  codpartida )
        USING INDEX partidamezcla_pk;

CREATE TABLE persona (
    codcia      NUMBER(6) NOT NULL,
    codpersona  NUMBER(6) NOT NULL,
    tippersona  VARCHAR2(1 BYTE) NOT NULL,
    despersona  VARCHAR2(100 BYTE) NOT NULL,
    descorta    VARCHAR2(30 BYTE) NOT NULL,
    descalterna VARCHAR2(100 BYTE) NOT NULL,
    descortaalt VARCHAR2(10 BYTE) NOT NULL,
    vigente     VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

COMMENT ON TABLE persona IS
    'Cliente de Codigo Cero es la Empresa Devenco';

COMMENT ON COLUMN persona.tippersona IS
    '1: Personal Devenco (Planilla y de Pys)
2: Cliente
3: Personal Cliente
4: Empresa - Consorcio';

COMMENT ON COLUMN persona.descortaalt IS
    'DescripciÃ³n corta de la Desc. Alterna';

CREATE UNIQUE INDEX persona_pk ON
    persona (
        codpersona
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE persona
    ADD CONSTRAINT persona_pk PRIMARY KEY ( codpersona,
                                            codcia )
        USING INDEX persona_pk;

CREATE TABLE proveedor (
    codcia       NUMBER(6) NOT NULL,
    codproveedor NUMBER(6) NOT NULL,
    nroruc       VARCHAR2(20 BYTE),
    vigente      VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX proveedor_pk ON
    proveedor (
        codproveedor
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE proveedor
    ADD CONSTRAINT proveedor_pk PRIMARY KEY ( codproveedor,
                                              codcia )
        USING INDEX proveedor_pk;

CREATE TABLE proy_partida (
    codcia      NUMBER(6) NOT NULL,
    codpyto     NUMBER(6) NOT NULL,
    nroversion  NUMBER(1) NOT NULL,
    ingegr      VARCHAR2(1 BYTE) NOT NULL,
    codpartida  NUMBER(6) NOT NULL,
    codpartidas VARCHAR2(12 BYTE) NOT NULL,
    flgcc       VARCHAR2(1 BYTE) NOT NULL,
    nivel       NUMBER(2) NOT NULL,
    unimed      VARCHAR2(5 BYTE) NOT NULL,
    tabestado   VARCHAR2(3 BYTE),
    codestado   VARCHAR2(3 BYTE),
    vigente     VARCHAR2(1 BYTE) NOT NULL,
    codcia_1    NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX proy_partida_pk ON
    proy_partida (
        codcia
    ASC,
        nroversion
    ASC,
        codpyto
    ASC,
        ingegr
    ASC,
        codpartida
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE proy_partida
    ADD CONSTRAINT proy_partida_pk PRIMARY KEY ( codcia,
                                                 nroversion,
                                                 codpyto,
                                                 ingegr,
                                                 codpartida )
        USING INDEX proy_partida_pk;

CREATE TABLE proy_partida_mezcla (
    codcia                  NUMBER(6) NOT NULL,
    codpyto                 NUMBER(6) NOT NULL,
    ingegr                  VARCHAR2(1 BYTE) NOT NULL,
    nroversion              NUMBER(1) NOT NULL,
    codpartida              NUMBER(6) NOT NULL,
    corr                    NUMBER(6) NOT NULL,
    padcodpartida           NUMBER(6) NOT NULL,
    tunimed                 VARCHAR2(3 BYTE) NOT NULL,
    eunimed                 VARCHAR2(3 BYTE) NOT NULL,
    nivel                   NUMBER(5) NOT NULL,
    orden                   NUMBER(5) NOT NULL,
    costounit               NUMBER(9, 2) NOT NULL,
    cant                    NUMBER(7, 3) NOT NULL,
    costotot                NUMBER(10, 2) NOT NULL,
    proy_partida_codcia     NUMBER(6),
    proy_partida_nroversion NUMBER(1),
    proy_partida_codpyto    NUMBER(6),
    proy_partida_ingegr     VARCHAR2(1 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX proy_partida_mezcla_pk ON
    proy_partida_mezcla (
        corr
    ASC,
        codcia
    ASC,
        nroversion
    ASC,
        codpyto
    ASC,
        ingegr
    ASC,
        codpartida
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE proy_partida_mezcla
    ADD CONSTRAINT proy_partida_mezcla_pk PRIMARY KEY ( corr,
                                                        codcia,
                                                        nroversion,
                                                        codpyto,
                                                        ingegr,
                                                        codpartida )
        USING INDEX proy_partida_mezcla_pk;

CREATE TABLE proyecto (
    codcia                         NUMBER(6) NOT NULL,
    codpyto                        NUMBER(6) NOT NULL,
    nompyto                        VARCHAR2(1000 BYTE) NOT NULL,
    empljefeproy                   NUMBER(6) NOT NULL,
    ciacontrata                    NUMBER(6) NOT NULL,
    codcliente                     NUMBER(6) NOT NULL,
    flgempconsorcio                VARCHAR2(1 BYTE),
    codsnip                        VARCHAR2(10 BYTE) NOT NULL,
    fecreg                         DATE NOT NULL,
    codfase                        NUMBER(1) NOT NULL,
    codnivel                       NUMBER(2) NOT NULL,
    codfuncion                     VARCHAR2(4 BYTE) NOT NULL,
    codsituacion                   NUMBER(2) NOT NULL,
    numinfor                       NUMBER(1) NOT NULL,
    numinforentrg                  NUMBER(1) NOT NULL,
    estpyto                        NUMBER(2) NOT NULL,
    fecestado                      DATE NOT NULL,
    valrefer                       NUMBER(12, 2) NOT NULL,
    costodirecto                   NUMBER(12, 2),
    costoggen                      NUMBER(12, 2),
    costofinan                     NUMBER(12, 2),
    imputilidad                    NUMBER(12, 2),
    costototsinigv                 NUMBER(12, 2),
    impigv                         NUMBER(12, 2),
    costototal                     NUMBER(12, 2),
    costopenalid                   NUMBER(12, 2),
    coddpto                        VARCHAR2(2 BYTE) NOT NULL,
    codprov                        VARCHAR2(2 BYTE) NOT NULL,
    coddist                        VARCHAR2(2 BYTE) NOT NULL,
    fecviab                        DATE NOT NULL,
    rutadoc                        VARCHAR2(300 BYTE) NOT NULL,
    annoini                        NUMBER(4) NOT NULL,
    annofin                        NUMBER(4) NOT NULL,
    codobjc                        NUMBER(2) NOT NULL,
    logoproy                       BLOB,
    tabestado                      VARCHAR2(3 BYTE),
    codestado                      VARCHAR2(3 BYTE),
    observac                       VARCHAR2(500 BYTE) NOT NULL,
    vigente                        VARCHAR2(1 BYTE) NOT NULL,
    cliente_persona_cia_codcia     NUMBER(6),
    empleado_persona_cia_codcia    NUMBER(6),
    empresa_vta_persona_cia_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY
    LOB ( logoproy ) STORE AS SECUREFILE (
        TABLESPACE users
        STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 BUFFER_POOL DEFAULT )
        CHUNK 8192
        RETENTION
        ENABLE STORAGE IN ROW
        NOCACHE LOGGING
    );

CREATE UNIQUE INDEX proyecto_pk ON
    proyecto (
        codpyto
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_pk PRIMARY KEY ( codpyto,
                                             codcia )
        USING INDEX proyecto_pk;

CREATE TABLE tabs (
    codtab   VARCHAR2(3 BYTE) NOT NULL,
    dentab   VARCHAR2(50 BYTE) NOT NULL,
    dencorta VARCHAR2(10 BYTE) NOT NULL,
    vigente  VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX tabs_pk ON
    tabs (
        codtab
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE tabs
    ADD CONSTRAINT tabs_pk PRIMARY KEY ( codtab )
        USING INDEX tabs_pk;

CREATE TABLE version_pres (
    codcia     NUMBER(6) NOT NULL,
    codpyto    NUMBER(6) NOT NULL,
    nroversion NUMBER(1) NOT NULL,
    fecini     DATE NOT NULL,
    fecfin     DATE NOT NULL,
    desversion VARCHAR2(100 BYTE) NOT NULL,
    descorta   VARCHAR2(17 BYTE) NOT NULL,
    tabestado  VARCHAR2(3 BYTE),
    codestado  VARCHAR2(3 BYTE),
    vigente    VARCHAR2(1 BYTE) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX version_pres_pk ON
    version_pres (
        nroversion
    ASC,
        codcia
    ASC,
        codpyto
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE version_pres
    ADD CONSTRAINT version_pres_pk PRIMARY KEY ( nroversion,
                                                 codcia,
                                                 codpyto )
        USING INDEX version_pres_pk;

CREATE TABLE vtacomp_pagocab (
    codcia                     NUMBER(6) NOT NULL,
    nrocp                      VARCHAR2(20 BYTE) NOT NULL,
    codpyto                    NUMBER(6) NOT NULL,
    codcliente                 NUMBER(6) NOT NULL,
    nropago                    NUMBER(3),
    tcomppago                  VARCHAR2(3 BYTE),
    ecomppago                  VARCHAR2(3 BYTE),
    feccp                      DATE,
    tmoneda                    VARCHAR2(3 BYTE),
    emoneda                    VARCHAR2(3 BYTE),
    tipcambio                  NUMBER(7, 4),
    impmo                      NUMBER(9, 2),
    impnetomn                  NUMBER(9, 2),
    impigvmn                   NUMBER(9, 2),
    imptotalmn                 NUMBER(10, 2),
    fecabono                   DATE,
    desabono                   VARCHAR2(1000 BYTE),
    semilla                    NUMBER(5),
    tabestado                  VARCHAR2(3 BYTE),
    codestado                  VARCHAR2(3 BYTE),
    proyecto_cia_codcia        NUMBER(6),
    cliente_persona_cia_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX vtacomp_pagocab_pk ON
    vtacomp_pagocab (
        nrocp
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_pk PRIMARY KEY ( nrocp,
                                                    codcia )
        USING INDEX vtacomp_pagocab_pk;

CREATE TABLE vtacomp_pagodet (
    codcia         NUMBER(6) NOT NULL,
    nrocp          VARCHAR2(20 BYTE) NOT NULL,
    sec            NUMBER(4) NOT NULL,
    ingegr         VARCHAR2(1 BYTE) NOT NULL,
    codpartida     NUMBER(6) NOT NULL,
    impnetomn      NUMBER(9, 2),
    impigvmn       NUMBER(9, 2),
    imptotalmn     NUMBER(9, 2),
    semilla        NUMBER(5),
    partida_codcia NUMBER(6)
)
PCTFREE 10 PCTUSED 40 TABLESPACE users LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX vtacomp_pagodet_pk ON
    vtacomp_pagodet (
        sec
    ASC,
        nrocp
    ASC,
        codcia
    ASC )
        TABLESPACE users PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE vtacomp_pagodet
    ADD CONSTRAINT vtacomp_pagodet_pk PRIMARY KEY ( sec,
                                                    nrocp,
                                                    codcia )
        USING INDEX vtacomp_pagodet_pk;

ALTER TABLE cliente
    ADD CONSTRAINT cliente_persona_fk FOREIGN KEY ( codcliente,
                                                    codcia )
        REFERENCES persona ( codpersona,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE elementos
    ADD CONSTRAINT codtab FOREIGN KEY ( codtab )
        REFERENCES tabs ( codtab )
    NOT DEFERRABLE;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_elementos_fk FOREIGN KEY ( ecomppago,
                                                           tcomppago )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_elementos_fkv2 FOREIGN KEY ( emoneda,
                                                             tmoneda )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_estado_fk FOREIGN KEY ( codestado,
                                                        tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_proveedor_fk FOREIGN KEY ( codproveedor,
                                                           codcia )
        REFERENCES proveedor ( codproveedor,
                                     codcia )
    NOT DEFERRABLE;

ALTER TABLE comp_pagocab
    ADD CONSTRAINT comp_pagocab_proyecto_fk FOREIGN KEY ( codpyto,
                                                          proyecto_cia_codcia )
        REFERENCES proyecto ( codpyto,
                                    codcia )
    NOT DEFERRABLE;

ALTER TABLE comp_pagodet
    ADD CONSTRAINT comp_pagodet_comp_pagocab_fk FOREIGN KEY ( nrocp,
                                                              codproveedor,
                                                              codcia )
        REFERENCES comp_pagocab ( nrocp,
                                        codproveedor,
                                        codcia )
    NOT DEFERRABLE;

ALTER TABLE comp_pagodet
    ADD CONSTRAINT comp_pagodet_partida_fk FOREIGN KEY ( partida_codcia,
                                                         ingegr,
                                                         codpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE dproy_partida_mezcla
    ADD CONSTRAINT dproy_partida_mezcla_elementos_fk FOREIGN KEY ( ecomppago,
                                                                   tcomppago )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE dproy_partida_mezcla
    ADD CONSTRAINT dproy_partida_mezcla_elementos_fkv2 FOREIGN KEY ( edesembolso,
                                                                     tdesembolso )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE dproy_partida_mezcla
    ADD CONSTRAINT dproy_partida_mezcla_proy_partida_mezcla_fk FOREIGN KEY ( corr,
                                                                             codcia,
                                                                             nroversion,
                                                                             codpyto,
                                                                             ingegr,
                                                                             codpartida )
        REFERENCES proy_partida_mezcla ( corr,
                                               codcia,
                                               nroversion,
                                               codpyto,
                                               ingegr,
                                               codpartida )
    NOT DEFERRABLE;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_persona_fk FOREIGN KEY ( codempleado,
                                                     codcia )
        REFERENCES persona ( codpersona,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE empresa_vta
    ADD CONSTRAINT empresa_persona_fk FOREIGN KEY ( ciacontrata,
                                                    codcia )
        REFERENCES persona ( codpersona,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE empresa_vta
    ADD CONSTRAINT empresa_vta_persona_fk FOREIGN KEY ( codempresa,
                                                        persona_codcia )
        REFERENCES persona ( codpersona,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE estado
    ADD CONSTRAINT estado_tabs_fk FOREIGN KEY ( tabestado )
        REFERENCES tabs ( codtab )
    NOT DEFERRABLE;

ALTER TABLE flujocaja_det
    ADD CONSTRAINT flujocaja_det_flujocaja_fk FOREIGN KEY ( tipo,
                                                            codcia,
                                                            ingegr,
                                                            codpartida,
                                                            codpyto )
        REFERENCES flujocaja ( tipo,
                                     codcia,
                                     ingegr,
                                     codpartida,
                                     codpyto )
    NOT DEFERRABLE;

ALTER TABLE flujocaja
    ADD CONSTRAINT flujocaja_estado_fk FOREIGN KEY ( codestado,
                                                     tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE flujocaja
    ADD CONSTRAINT flujocaja_partida_fk FOREIGN KEY ( codcia,
                                                      ingegr,
                                                      codpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE flujocaja
    ADD CONSTRAINT flujocaja_proyecto_fk FOREIGN KEY ( codpyto,
                                                       proyecto_cia_codcia )
        REFERENCES proyecto ( codpyto,
                                    codcia )
    NOT DEFERRABLE;

ALTER TABLE partida
    ADD CONSTRAINT partida_elementos_fk FOREIGN KEY ( eunimed,
                                                      tunimed )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE partida
    ADD CONSTRAINT partida_empresa_fk FOREIGN KEY ( empresa_codpersona,
                                                    codcia )
        REFERENCES empresa_vta ( ciacontrata,
                                       codcia )
    NOT DEFERRABLE;

ALTER TABLE partidamezcla
    ADD CONSTRAINT partidamezcla_elementos_fk FOREIGN KEY ( eunimed,
                                                            tunimed )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE partidamezcla
    ADD CONSTRAINT partidamezcla_partida_fk FOREIGN KEY ( codcia,
                                                          ingegr,
                                                          codpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE partidamezcla
    ADD CONSTRAINT partidamezcla_partida_fkv1 FOREIGN KEY ( partida_codcia,
                                                            partida_ingegr,
                                                            padcodpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE persona
    ADD CONSTRAINT persona_cia_fk FOREIGN KEY ( codcia )
        REFERENCES cia ( codcia )
    NOT DEFERRABLE;

ALTER TABLE proveedor
    ADD CONSTRAINT proveedor_persona_fk FOREIGN KEY ( codproveedor,
                                                      codcia )
        REFERENCES persona ( codpersona,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE proy_partida
    ADD CONSTRAINT proy_partida_estado_fk FOREIGN KEY ( codestado,
                                                        tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE proy_partida_mezcla
    ADD CONSTRAINT proy_partida_mezcla_elementos_fk FOREIGN KEY ( eunimed,
                                                                  tunimed )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE proy_partida_mezcla
    ADD CONSTRAINT proy_partida_mezcla_proy_partida_fk FOREIGN KEY ( codcia,
                                                                     nroversion,
                                                                     codpyto,
                                                                     ingegr,
                                                                     codpartida )
        REFERENCES proy_partida ( codcia,
                                        nroversion,
                                        codpyto,
                                        ingegr,
                                        codpartida )
    NOT DEFERRABLE;

ALTER TABLE proy_partida_mezcla
    ADD CONSTRAINT proy_partida_mezcla_proy_partida_fkv1 FOREIGN KEY ( proy_partida_codcia,
                                                                       proy_partida_nroversion,
                                                                       proy_partida_codpyto,
                                                                       proy_partida_ingegr,
                                                                       padcodpartida )
        REFERENCES proy_partida ( codcia,
                                        nroversion,
                                        codpyto,
                                        ingegr,
                                        codpartida )
    NOT DEFERRABLE;

ALTER TABLE proy_partida
    ADD CONSTRAINT proy_partida_partida_fk FOREIGN KEY ( codcia_1,
                                                         ingegr,
                                                         codpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE proy_partida
    ADD CONSTRAINT proy_partida_version_pres_fk FOREIGN KEY ( nroversion,
                                                              codcia,
                                                              codpyto )
        REFERENCES version_pres ( nroversion,
                                        codcia,
                                        codpyto )
    NOT DEFERRABLE;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_cia_fk FOREIGN KEY ( codcia )
        REFERENCES cia ( codcia )
    NOT DEFERRABLE;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_cliente_fk FOREIGN KEY ( codcliente,
                                                     cliente_persona_cia_codcia )
        REFERENCES cliente ( codcliente,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_empleado_fk FOREIGN KEY ( empljefeproy,
                                                      empleado_persona_cia_codcia )
        REFERENCES empleado ( codempleado,
                                    codcia )
    NOT DEFERRABLE;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_empresa_vta_fk FOREIGN KEY ( ciacontrata,
                                                         empresa_vta_persona_cia_codcia )
        REFERENCES empresa_vta ( ciacontrata,
                                       codcia )
    NOT DEFERRABLE;

ALTER TABLE proyecto
    ADD CONSTRAINT proyecto_estado_fk FOREIGN KEY ( codestado,
                                                    tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE version_pres
    ADD CONSTRAINT version_pres_estado_fk FOREIGN KEY ( codestado,
                                                        tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE version_pres
    ADD CONSTRAINT version_pres_proyecto_fk FOREIGN KEY ( codpyto,
                                                          codcia )
        REFERENCES proyecto ( codpyto,
                                    codcia )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_cia_fk FOREIGN KEY ( codcia )
        REFERENCES cia ( codcia )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_cliente_fk FOREIGN KEY ( codcliente,
                                                            cliente_persona_cia_codcia )
        REFERENCES cliente ( codcliente,
                                   codcia )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_elementos_fk FOREIGN KEY ( ecomppago,
                                                              tcomppago )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_elementos_fkv2 FOREIGN KEY ( emoneda,
                                                                tmoneda )
        REFERENCES elementos ( codelem,
                                     codtab )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_estado_fk FOREIGN KEY ( codestado,
                                                           tabestado )
        REFERENCES estado ( codestado,
                                  tabestado )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagocab
    ADD CONSTRAINT vtacomp_pagocab_proyecto_fk FOREIGN KEY ( codpyto,
                                                             proyecto_cia_codcia )
        REFERENCES proyecto ( codpyto,
                                    codcia )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagodet
    ADD CONSTRAINT vtacomp_pagodet_partida_fk FOREIGN KEY ( partida_codcia,
                                                            ingegr,
                                                            codpartida )
        REFERENCES partida ( codcia,
                                   ingegr,
                                   codpartida )
    NOT DEFERRABLE;

ALTER TABLE vtacomp_pagodet
    ADD CONSTRAINT vtacomp_pagodet_vtacomp_pagocab_fk FOREIGN KEY ( nrocp,
                                                                    codcia )
        REFERENCES vtacomp_pagocab ( nrocp,
                                           codcia )
    NOT DEFERRABLE;
    
INSERT INTO CIA (CODCIA, DESCIA, DESCORTA, VIGENTE) VALUES ('0001', 'Compañia de Seguros La Positiva', 'La Positiva', '1');
INSERT INTO PERSONA (CODCIA, CODPERSONA, TIPPERSONA, DESPERSONA, DESCORTA, DESCALTERNA, DESCORTAALT, VIGENTE) VALUES ('0001', '1000', '2', 'Persona Juridica', 'PJ', 'Compañia', 'COP', '0');
INSERT INTO PERSONA (CODCIA, CODPERSONA, TIPPERSONA, DESPERSONA, DESCORTA, DESCALTERNA, DESCORTAALT, VIGENTE) VALUES ('0001', '2000', '3', 'Persona Natural', 'PN', 'Pequeña Empresa', 'PYME', '1');
INSERT INTO EMPRESA_VTA (CODCIA, CIACONTRATA, NRORUC, FLGEMPCONSORCIO, FECINI, FECFIN, CODEMPRESA, OBSERVAC, VIGENTE) VALUES ('0001', '1000', '20495552629', '1', TO_DATE('2016-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-08-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '1000', 'Empresa deudora', '0');
INSERT INTO EMPRESA_VTA (CODCIA, CIACONTRATA, NRORUC, FLGEMPCONSORCIO, FECINI, FECFIN, CODEMPRESA, OBSERVAC, VIGENTE) VALUES ('0001', '2000', '20562223514', '0', TO_DATE('2018-12-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2021-03-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '2000', 'Empresa en venta', '1');
INSERT INTO CLIENTE (CODCIA, CODCLIENTE, NRORUC, VIGENTE) VALUES ('0001', '1000', '21568887545', '0');
INSERT INTO CLIENTE (CODCIA, CODCLIENTE, NRORUC, VIGENTE) VALUES ('0001', '2000', '23569991213', '1');
INSERT INTO PROVEEDOR (CODCIA, CODPROVEEDOR, NRORUC, VIGENTE) VALUES ('0001', '1000', '23200001548', '0');
INSERT INTO PROVEEDOR (CODCIA, CODPROVEEDOR, NRORUC, VIGENTE) VALUES ('0001', '2000', '40156662021', '1');
Insert into EMPLEADO (CODCIA,CODEMPLEADO,DIRECC,CELULAR,HOBBY,FECNAC,DNI,NROCIP,FECCIPVIG,LICCOND,FLGEMPLIEA,OBSERVAC,CODCARGO,EMAIL,VIGENTE) values ('0001','2000','los laureles','975983945','leer',to_date('08/12/22','DD/MM/RR'),'324667','124',to_date('14/12/22','DD/MM/RR'),'1','0','buen empleado','1','correo','0');
INSERT INTO TABS (CODTAB, DENTAB, DENCORTA, VIGENTE) VALUES ('010', 'Moneda', 'MON', '1');
INSERT INTO TABS (CODTAB, DENTAB, DENCORTA, VIGENTE) VALUES ('020', 'Unidad de Medida', 'UM', '0');
INSERT INTO TABS (CODTAB, DENTAB, DENCORTA, VIGENTE) VALUES ('030', 'Compr', 'CP', '1');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('010', 'PEN', 'Sol', 'moneda', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('010', 'EUR', 'Euro', 'moneda', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('010', 'USD', 'Dolar Americano', 'moneda', '1');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('020', 'Kg', 'Kilogramo', 'kilo', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('020', 'Lb', 'Libra', 'libra', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('030', 'FAC', 'Factura', 'comprob', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('030', 'HX', 'Hx', 'comprob', '0');
INSERT INTO ELEMENTOS (CODTAB, CODELEM, DENELE, DENCORTA, VIGENTE) VALUES ('030', 'VAU', 'Vaucher', 'comprob', '0');
INSERT INTO ESTADO (TABESTADO, CODESTADO, DESESTADO, DESCORTA, VIGENTE) VALUES ('010', '004', 'Espera', 'espera', '1');
INSERT INTO ESTADO (TABESTADO, CODESTADO, DESESTADO, DESCORTA, VIGENTE) VALUES ('010', '002', 'prueba', 'prue', '1');
INSERT INTO ESTADO (TABESTADO, CODESTADO, DESESTADO, DESCORTA, VIGENTE) VALUES ('010', '001', 'Registrado', 'registrado', '1');
INSERT INTO ESTADO (TABESTADO, CODESTADO, DESESTADO, DESCORTA, VIGENTE) VALUES ('010', '003', 'No registrado', 'No regis', '1');
INSERT INTO PROYECTO (CODCIA,CODPYTO,NOMPYTO,EMPLJEFEPROY,CIACONTRATA,CODCLIENTE,FLGEMPCONSORCIO,CODSNIP,FECREG,CODFASE,CODNIVEL,CODFUNCION,CODSITUACION,NUMINFOR,NUMINFORENTRG,ESTPYTO,FECESTADO,VALREFER,COSTODIRECTO,COSTOGGEN,COSTOFINAN,IMPUTILIDAD,COSTOTOTSINIGV,IMPIGV,COSTOTOTAL,COSTOPENALID,CODDPTO,CODPROV,CODDIST,FECVIAB,OBSERVAC,RUTADOC,ANNOINI,ANNOFIN,CODOBJC,TABESTADO,CODESTADO,VIGENTE,CLIENTE_PERSONA_CIA_CODCIA,EMPLEADO_PERSONA_CIA_CODCIA,EMPRESA_VTA_PERSONA_CIA_CODCIA) values (1,1000,'Talara',1000,2000,1000,'0','1',TO_DATE('2022-05-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,1,'1',1,1,1,1,TO_DATE('2016-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),1,1,1,1,1,1,1,1,1,'1','1','1',TO_DATE('2022-05-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),'1','1',2019,2026,1,'010','002','1',null,null,null);
INSERT INTO VERSION_PRES (CODCIA, CODPYTO, NROVERSION, FECINI, FECFIN, DESVERSION, DESCORTA, TABESTADO, CODESTADO, VIGENTE) VALUES ('0001', '1000', '1', TO_DATE('2016-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2026-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Original', 'Ori', '010', '002', '0');
INSERT INTO VERSION_PRES (CODCIA, CODPYTO, NROVERSION, FECINI, FECFIN, DESVERSION, DESCORTA, TABESTADO, CODESTADO, VIGENTE) VALUES ('0001', '1000', '2', TO_DATE('2016-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2026-05-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Finalizado', 'Fin', '010', '002', '1');
commit;

create or replace NONEDITIONABLE TRIGGER FLUJODETPPM
AFTER INSERT OR UPDATE ON DPROY_PARTIDA_MEZCLA
FOR EACH ROW
DECLARE
    vnivel NUMBER(1);
    vorden NUMBER(5);
    vdesconcepto VARCHAR2(30 BYTE);
    vdesconceptocorto VARCHAR2(10 BYTE);
    vtabestado VARCHAR2(3 BYTE);
    vcodestado VARCHAR2(3 BYTE);
    vanno NUMBER(4);
    vvigente VARCHAR2(1 BYTE);
    CURSOR C IS SELECT SEMILLA FROM FLUJOCAJA;
    CURSOR D IS SELECT ANNO, CODPARTIDA FROM FLUJOCAJA_DET;
    bandera NUMBER;
    cont NUMBER;
BEGIN
    SELECT NIVEL, DESPARTIDA INTO vnivel, vdesconcepto FROM PARTIDA WHERE CODCIA = :NEW.CODCIA AND INGEGR = :NEW.INGEGR AND CODPARTIDA = :NEW.CODPARTIDA;
    vdesconceptocorto := SUBSTR(vdesconcepto, 1, 10);
    SELECT TABESTADO, CODESTADO, VIGENTE INTO vtabestado, vcodestado, vvigente FROM PROY_PARTIDA WHERE CODCIA = :NEW.CODCIA AND CODPYTO = :NEW.CODPYTO 
    AND INGEGR = :NEW.INGEGR AND NROVERSION = :NEW.NROVERSION AND CODPARTIDA = :NEW.CODPARTIDA;
    vanno := TO_NUMBER(TO_CHAR(:NEW.FECDESEMBOLSO, 'YYYY'));
    SELECT ORDEN INTO vorden FROM PROY_PARTIDA_MEZCLA WHERE CODCIA = :NEW.CODCIA AND CODPYTO = :NEW.CODPYTO 
    AND INGEGR = :NEW.INGEGR AND NROVERSION = :NEW.NROVERSION AND CODPARTIDA = :NEW.CODPARTIDA;
    SELECT COUNT(*) INTO cont FROM FLUJOCAJA;

    IF cont = 0 THEN
        INSERT INTO FLUJOCAJA(CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, NIVEL, ORDEN, DESCONCEPTO, DESCONCEPTOCORTO, SEMILLA, RAIZ, TABESTADO, CODESTADO, VIGENTE) 
        VALUES (:NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vnivel, vorden, vdesconcepto, vdesconceptocorto, :NEW.SEMILLA, 1, vtabestado, vcodestado, vvigente);

        INSERT INTO FLUJOCAJA_DET(ANNO, CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, ORDEN, IMPINI, IMPREALINI, IMPENE, IMPREALENE, IMPFEB, IMPREALFEB, IMPMAR, IMPREALMAR, IMPABR, IMPREALABR, 
            IMPMAY, IMPREALMAY, IMPJUN, IMPREALJUN, IMPJUL, IMPREALJUL, IMPAGO, IMPREALAGO, IMPSET, IMPREALSET, IMPOCT, IMPREALOCT, IMPNOV, IMPREALNOV, IMPDIC, IMPREALDIC, IMPACUM, IMPREALACUM) 
            VALUES (vanno, :NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vorden, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0);   
    END IF;

    SELECT COUNT(*) INTO cont FROM FLUJOCAJA_DET;
    IF cont = 0 THEN
        INSERT INTO FLUJOCAJA_DET(ANNO, CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, ORDEN, IMPINI, IMPREALINI, IMPENE, IMPREALENE, IMPFEB, IMPREALFEB, IMPMAR, IMPREALMAR, IMPABR, IMPREALABR, 
        IMPMAY, IMPREALMAY, IMPJUN, IMPREALJUN, IMPJUL, IMPREALJUL, IMPAGO, IMPREALAGO, IMPSET, IMPREALSET, IMPOCT, IMPREALOCT, IMPNOV, IMPREALNOV, IMPDIC, IMPREALDIC, IMPACUM, IMPREALACUM) 
        VALUES (vanno, :NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vorden, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0);
    END IF;

    bandera := 0;
    FOR i IN C LOOP
        IF i.SEMILLA = :NEW.SEMILLA AND bandera = 0 THEN 
            bandera := 1;
        END IF;
    END LOOP;
    IF bandera = 0 then
        IF INSERTING THEN
            INSERT INTO FLUJOCAJA(CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, NIVEL, ORDEN, DESCONCEPTO, DESCONCEPTOCORTO, SEMILLA, RAIZ, TABESTADO, CODESTADO, VIGENTE) 
            VALUES (:NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vnivel, vorden, vdesconcepto, vdesconceptocorto, :NEW.SEMILLA, 1, vtabestado, vcodestado, vvigente);
            
            INSERT INTO FLUJOCAJA_DET(ANNO, CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, ORDEN, IMPINI, IMPREALINI, IMPENE, IMPREALENE, IMPFEB, IMPREALFEB, IMPMAR, IMPREALMAR, IMPABR, IMPREALABR, 
            IMPMAY, IMPREALMAY, IMPJUN, IMPREALJUN, IMPJUL, IMPREALJUL, IMPAGO, IMPREALAGO, IMPSET, IMPREALSET, IMPOCT, IMPREALOCT, IMPNOV, IMPREALNOV, IMPDIC, IMPREALDIC, IMPACUM, IMPREALACUM) 
            VALUES (vanno, :NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vorden, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0);
        END IF;
            
        IF UPDATING THEN
            UPDATE FLUJOCAJA SET NIVEL = vnivel, ORDEN = vorden, DESCONCEPTO = vdesconcepto, DESCONCEPTOCORTO = vdesconceptocorto, 
            SEMILLA = :NEW.SEMILLA, RAIZ = 1, TABESTADO = vtabestado, CODESTADO = vcodestado, VIGENTE = vvigente 
            WHERE CODCIA = :NEW.CODCIA AND CODPYTO = :NEW.CODPYTO AND INGEGR = :NEW.INGEGR AND TIPO = 'P' AND CODPARTIDA = :NEW.CODPARTIDA;
            
            INSERT INTO FLUJOCAJA_DET(ANNO, CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, ORDEN, IMPINI, IMPREALINI, IMPENE, IMPREALENE, IMPFEB, IMPREALFEB, IMPMAR, IMPREALMAR, IMPABR, IMPREALABR, 
            IMPMAY, IMPREALMAY, IMPJUN, IMPREALJUN, IMPJUL, IMPREALJUL, IMPAGO, IMPREALAGO, IMPSET, IMPREALSET, IMPOCT, IMPREALOCT, IMPNOV, IMPREALNOV, IMPDIC, IMPREALDIC, IMPACUM, IMPREALACUM) 
            VALUES (vanno, :NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vorden, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0);
        END IF;
    END IF;

    bandera := 0;
    FOR i IN D LOOP
        IF i.ANNO = vanno AND i.CODPARTIDA = :NEW.CODPARTIDA AND bandera = 0 THEN
            bandera := 1;
        END IF;
    END LOOP; 
    IF bandera = 0 then
        INSERT INTO FLUJOCAJA_DET(ANNO, CODCIA, CODPYTO, INGEGR, TIPO, CODPARTIDA, ORDEN, IMPINI, IMPREALINI, IMPENE, IMPREALENE, IMPFEB, IMPREALFEB, IMPMAR, IMPREALMAR, IMPABR, IMPREALABR, 
            IMPMAY, IMPREALMAY, IMPJUN, IMPREALJUN, IMPJUL, IMPREALJUL, IMPAGO, IMPREALAGO, IMPSET, IMPREALSET, IMPOCT, IMPREALOCT, IMPNOV, IMPREALNOV, IMPDIC, IMPREALDIC, IMPACUM, IMPREALACUM) 
            VALUES (vanno, :NEW.CODCIA, :NEW.CODPYTO, :NEW.INGEGR, 'P', :NEW.CODPARTIDA, vorden, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0, 0 ,0);
    END IF;
END;

create or replace NONEDITIONABLE PROCEDURE ACTUALIZARFC AS 
BEGIN
    FOR FC IN (SELECT * FROM flujocaja_det ORDER BY ANNO ASC) LOOP
        UPDATE flujocaja_det SET impini = 0  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE flujocaja_det SET imprealini = 0  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE flujocaja_det SET IMPREALACUM = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE flujocaja_det SET IMPACUM = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        
        FOR I IN (SELECT * FROM flujocaja_det 
            WHERE FC.CODCIA = CODCIA AND FC.CODPYTO = CODPYTO
                AND FC.INGEGR = INGEGR AND FC.TIPO = TIPO 
                AND FC.CODPARTIDA = CODPARTIDA AND FC.ANNO-1 = ANNO) LOOP
                    DBMS_OUTPUT.PUT_LINE( fc.anno || i.anno);
                    UPDATE flujocaja_det SET impini = i.IMPACUM  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    UPDATE flujocaja_det SET imprealini = i.IMPrealACUM  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        END LOOP;
        
        UPDATE flujocaja_det SET impene = 0  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPFEB = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPMAR = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPABR = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPMAY = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPJUN = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPJUL = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPAGO = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPSET = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPOCT = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPNOV = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPDIC = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        
        UPDATE FLUJOCAJA_DET SET  IMPREALENE = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALFEB = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALMAR = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALABR = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALMAY = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALJUN = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALJUL = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALAGO = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALSET = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALOCT = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALNOV = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        UPDATE FLUJOCAJA_DET SET  IMPREALDIC = 0 WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
        
        
        FOR MES in (SELECT column_value FROM table(sys.dbms_debug_vc2coll('01','02','03','04','05','06','07','08','09','10','11','12'))) LOOP
            FOR i IN (SELECT D.* FROM DPROY_PARTIDA_MEZCLA D 
            INNER JOIN FLUJOCAJA P 
                ON FC.CODCIA = P.CODCIA AND FC.CODPYTO = P.CODPYTO
                AND FC.INGEGR = P.INGEGR AND FC.TIPO = P.TIPO AND FC.CODPARTIDA = P.CODPARTIDA
            WHERE D.SEMILLA = P.SEMILLA
                AND TO_CHAR(fecdesembolso, 'YYYY') = TO_CHAR(FC.ANNO) 
                AND TO_CHAR(FECDESEMBOLSO, 'MM') = mes.column_value AND D.INGEGR = FC.INGEGR) 
            LOOP
                    IF mes.column_value ='01' THEN UPDATE flujocaja_det SET impene = impene + i.IMPDESEMBTOT  WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='02' THEN UPDATE FLUJOCAJA_DET SET  IMPFEB = i.IMPDESEMBTOT + IMPFEB WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='03' THEN UPDATE FLUJOCAJA_DET SET  IMPMAR = i.IMPDESEMBTOT + IMPMAR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='04' THEN UPDATE FLUJOCAJA_DET SET  IMPABR = i.IMPDESEMBTOT + IMPABR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='05' THEN UPDATE FLUJOCAJA_DET SET  IMPMAY = i.IMPDESEMBTOT + IMPMAY WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='06' THEN UPDATE FLUJOCAJA_DET SET  IMPJUN = i.IMPDESEMBTOT + IMPJUN WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='07' THEN UPDATE FLUJOCAJA_DET SET  IMPJUL = i.IMPDESEMBTOT + IMPJUL WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='08' THEN UPDATE FLUJOCAJA_DET SET  IMPAGO = i.IMPDESEMBTOT + IMPAGO WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='09' THEN UPDATE FLUJOCAJA_DET SET  IMPSET = i.IMPDESEMBTOT + IMPSET WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='10' THEN UPDATE FLUJOCAJA_DET SET  IMPOCT = i.IMPDESEMBTOT + IMPOCT WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='11' THEN UPDATE FLUJOCAJA_DET SET  IMPNOV = i.IMPDESEMBTOT + IMPNOV WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    ELSIF mes.column_value ='12' THEN UPDATE FLUJOCAJA_DET SET  IMPDIC = i.IMPDESEMBTOT + IMPDIC WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                    END IF;
            END LOOP;
        END LOOP;
    
        FOR MES in (SELECT column_value FROM table(sys.dbms_debug_vc2coll('01','02','03','04','05','06','07','08','09','10','11','12'))) LOOP
            IF UPPER(FC.INGEGR) = 'I' THEN
                FOR i IN (SELECT D.* FROM VTACOMP_PAGODET D 
                INNER JOIN FLUJOCAJA P 
                    ON FC.CODCIA = P.CODCIA AND FC.CODPYTO = P.CODPYTO
                    AND FC.INGEGR = P.INGEGR AND FC.TIPO = P.TIPO AND FC.CODPARTIDA = P.CODPARTIDA
                INNER JOIN vtacomp_pagocab R 
                    ON D.CODCIA = R.CODCIA AND d.nrocp = r.nrocp
                WHERE D.SEMILLA = P.SEMILLA AND P.CODCIA = d.codcia
                    AND TO_CHAR(R.fecabono, 'YYYY') = TO_CHAR(FC.ANNO) 
                    AND TO_CHAR(R.fecabono, 'MM') = mes.column_value ) LOOP
                        IF mes.column_value ='01' THEN UPDATE FLUJOCAJA_DET SET  IMPREALENE = i.IMPTOTALMN + IMPREALENE WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='02' THEN UPDATE FLUJOCAJA_DET SET  IMPREALFEB = i.IMPTOTALMN + IMPREALFEB WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='03' THEN UPDATE FLUJOCAJA_DET SET  IMPREALMAR = i.IMPTOTALMN + IMPREALMAR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='04' THEN UPDATE FLUJOCAJA_DET SET  IMPREALABR = i.IMPTOTALMN + IMPREALABR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='05' THEN UPDATE FLUJOCAJA_DET SET  IMPREALMAY = i.IMPTOTALMN + IMPREALMAY WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='06' THEN UPDATE FLUJOCAJA_DET SET  IMPREALJUN = i.IMPTOTALMN + IMPREALJUN WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='07' THEN UPDATE FLUJOCAJA_DET SET  IMPREALJUL = i.IMPTOTALMN + IMPREALJUL WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='08' THEN UPDATE FLUJOCAJA_DET SET  IMPREALAGO = i.IMPTOTALMN + IMPREALAGO WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='09' THEN UPDATE FLUJOCAJA_DET SET  IMPREALSET = i.IMPTOTALMN + IMPREALSET WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='10' THEN UPDATE FLUJOCAJA_DET SET  IMPREALOCT = i.IMPTOTALMN + IMPREALOCT WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='11' THEN UPDATE FLUJOCAJA_DET SET  IMPREALNOV = i.IMPTOTALMN + IMPREALNOV WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='12' THEN UPDATE FLUJOCAJA_DET SET  IMPREALDIC = i.IMPTOTALMN + IMPREALDIC WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        END IF;
                END LOOP;
            ELSE
                FOR i IN (SELECT D.* FROM COMP_PAGODET D 
                INNER JOIN FLUJOCAJA P 
                    ON FC.CODCIA = P.CODCIA AND FC.CODPYTO = P.CODPYTO
                    AND FC.INGEGR = P.INGEGR AND FC.TIPO = P.TIPO AND FC.CODPARTIDA = P.CODPARTIDA
                INNER JOIN comp_pagocab R 
                    ON D.CODCIA = R.CODCIA AND d.nrocp = r.nrocp AND d.codproveedor = r.codproveedor
                WHERE D.SEMILLA = P.SEMILLA AND P.CODCIA = d.codcia
                    AND TO_CHAR(r.fecabono, 'YYYY') = TO_CHAR(FC.ANNO) 
                    AND TO_CHAR(r.fecabono, 'MM') = mes.column_value ) LOOP
    
                        IF mes.column_value ='01' THEN UPDATE FLUJOCAJA_DET SET  IMPREALENE = i.IMPTOTALMN + IMPREALENE WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='02' THEN UPDATE FLUJOCAJA_DET SET  IMPREALFEB = i.IMPTOTALMN + IMPREALFEB WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='03' THEN UPDATE FLUJOCAJA_DET SET  IMPREALMAR = i.IMPTOTALMN + IMPREALMAR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='04' THEN UPDATE FLUJOCAJA_DET SET  IMPREALABR = i.IMPTOTALMN + IMPREALABR WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='05' THEN UPDATE FLUJOCAJA_DET SET  IMPREALMAY = i.IMPTOTALMN + IMPREALMAY WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='06' THEN UPDATE FLUJOCAJA_DET SET  IMPREALJUN = i.IMPTOTALMN + IMPREALJUN WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='07' THEN UPDATE FLUJOCAJA_DET SET  IMPREALJUL = i.IMPTOTALMN + IMPREALJUL WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='08' THEN UPDATE FLUJOCAJA_DET SET  IMPREALAGO = i.IMPTOTALMN + IMPREALAGO WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='09' THEN UPDATE FLUJOCAJA_DET SET  IMPREALSET = i.IMPTOTALMN + IMPREALSET WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='10' THEN UPDATE FLUJOCAJA_DET SET  IMPREALOCT = i.IMPTOTALMN + IMPREALOCT WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='11' THEN UPDATE FLUJOCAJA_DET SET  IMPREALNOV = i.IMPTOTALMN + IMPREALNOV WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        ELSIF mes.column_value ='12' THEN UPDATE FLUJOCAJA_DET SET  IMPREALDIC = i.IMPTOTALMN + IMPREALDIC WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
                        END IF;
                END LOOP;
            END IF;
        END LOOP;
        
        UPDATE flujocaja_det SET IMPREALACUM = IMPREALINI + IMPREALENE + IMPREALFEB + 
            IMPREALMAR + IMPREALABR + IMPREALMAY + IMPREALJUN + 
            IMPREALJUL + IMPREALAGO + IMPREALSET + IMPREALOCT + 
            IMPREALNOV + IMPREALDIC WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
              
        UPDATE flujocaja_det SET IMPACUM = IMPINI + IMPENE + IMPFEB + 
            IMPMAR + IMPABR + IMPMAY + IMPJUN + 
            IMPJUL + IMPAGO + IMPSET + IMPOCT + 
            IMPNOV + IMPDIC WHERE  CODCIA = FC.CODCIA AND CODPYTO = FC.CODPYTO AND INGEGR = FC.INGEGR AND TIPO = FC.TIPO AND CODPARTIDA = FC.CODPARTIDA AND ANNO = FC.ANNO;
            
    END LOOP;
END ACTUALIZARFC;

create or replace NONEDITIONABLE TRIGGER CREARFLUJOCAJA
AFTER INSERT OR UPDATE ON COMP_PAGODET
FOR EACH ROW
DECLARE
        bandera Number(5,0):= 1;
        bandera2 Number(5,0):= 0;
BEGIN

            IF bandera = 1 Then
                FOR I IN (SELECT P.* FROM FLUJOCAJA_DET P 
                INNER JOIN FLUJOCAJA F
                    on P.CODCIA = F.CODCIA AND P.CODPYTO = F.CODPYTO AND P.INGEGR = F.INGEGR
                        AND P.TIPO = F.TIPO AND  P.CODPARTIDA = F.CODPARTIDA
                    WHERE F.SEMILLA = :NEW.semilla)
                loop
                    FOR J IN (SELECT P.* FROM comp_pagocab P 
                        WHERE :NEW.codcia=p.codcia and :NEW.codproveedor=p.codproveedor and :NEW.nrocp=p.nrocp)
                    loop
                        IF TO_CHAR(J.fecabono, 'YYYY') = TO_CHAR(I.ANNO)  THEN
                            bandera2:=4;
                        END IF;
                    END LOOP;
                END LOOP;

                IF bandera2=0 then
                    FOR J IN (SELECT P.* FROM comp_pagocab P 
                        WHERE :NEW.codcia=p.codcia and :NEW.codproveedor=p.codproveedor and :NEW.nrocp=p.nrocp)
                    loop

                        FOR k IN (SELECT P.* FROM flujocaja P 
                        WHERE :NEW.semilla=p.semilla)
                        loop
                            INSERT INTO FLUJOCAJA_DET  VALUES (TO_NUMBER(TO_CHAR(J.fecabono, 'YYYY')),K.CODCIA,K.CODPYTO,
                                K.INGEGR,'P',K.CODPARTIDA,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
                        END LOOP;

                    END LOOP;
                end if;
            END IF;
END;

create or replace NONEDITIONABLE TRIGGER CREARFLUJOCAJAVTA
AFTER INSERT OR UPDATE ON VTACOMP_PAGODET
FOR EACH ROW
DECLARE
        bandera Number(5,0):= 1;
        bandera2 Number(5,0):= 0;
BEGIN

            IF bandera = 1 Then
                FOR I IN (SELECT P.* FROM FLUJOCAJA_DET P 
                INNER JOIN FLUJOCAJA F
                    on P.CODCIA = F.CODCIA AND P.CODPYTO = F.CODPYTO AND P.INGEGR = F.INGEGR
                        AND P.TIPO = F.TIPO AND  P.CODPARTIDA = F.CODPARTIDA
                    WHERE F.SEMILLA = :NEW.semilla)
                loop
                    FOR J IN (SELECT P.* FROM vtacomp_pagocab P 
                        WHERE :NEW.codcia=p.codcia  and :NEW.nrocp=p.nrocp)
                    loop
                        IF TO_CHAR(J.fecabono, 'YYYY') = TO_CHAR(I.ANNO)  THEN
                            bandera2:=4;
                        END IF;
                    END LOOP;
                END LOOP;

                IF bandera2=0 then
                    FOR J IN (SELECT P.* FROM vtacomp_pagocab P 
                        WHERE :NEW.codcia=p.codcia  and :NEW.nrocp=p.nrocp)
                    loop 
                        DBMS_OUTPUT.PUT_LINE( :new.CODCIA || J.CODPYTO || :new.INGEGR || :new.CODPARTIDA);
                    
                        FOR k IN (SELECT P.* FROM flujocaja P 
                        WHERE :NEW.semilla=p.semilla)
                        loop
                            INSERT INTO FLUJOCAJA_DET  VALUES (TO_NUMBER(TO_CHAR(J.fecabono, 'YYYY')),K.CODCIA,K.CODPYTO,
                                K.INGEGR,'P',K.CODPARTIDA,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
                        END LOOP;

                    END LOOP;
                end if;
            END IF;
END;