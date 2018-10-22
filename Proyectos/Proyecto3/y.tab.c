/* original parser id follows */
/* yysccsid[] = "@(#)yaccpar	1.9 (Berkeley) 02/21/93" */
/* (use YYMAJOR/YYMINOR for ifdefs dependent on parser version) */

#define YYBYACC 1
#define YYMAJOR 1
#define YYMINOR 9
#define YYPATCH 20140715

#define YYEMPTY        (-1)
#define yyclearin      (yychar = YYEMPTY)
#define yyerrok        (yyerrflag = 0)
#define YYRECOVERING() (yyerrflag != 0)
#define YYENOMEM       (-2)
#define YYEOF          0
#define YYPREFIX "yy"

#define YYPURE 0

#line 2 "src/main/byaccj/Parser.y"
  import ast.patron.compuesto.*;
  import java.lang.Math;
  import java.io.*;
#line 25 "y.tab.c"

#if ! defined(YYSTYPE) && ! defined(YYSTYPE_IS_DECLARED)
/* Default: YYSTYPE is the semantic value type. */
typedef int YYSTYPE;
# define YYSTYPE_IS_DECLARED 1
#endif

/* compatibility with bison */
#ifdef YYPARSE_PARAM
/* compatibility with FreeBSD */
# ifdef YYPARSE_PARAM_TYPE
#  define YYPARSE_DECL() yyparse(YYPARSE_PARAM_TYPE YYPARSE_PARAM)
# else
#  define YYPARSE_DECL() yyparse(void *YYPARSE_PARAM)
# endif
#else
# define YYPARSE_DECL() yyparse(void)
#endif

/* Parameters sent to lex. */
#ifdef YYLEX_PARAM
# define YYLEX_DECL() yylex(void *YYLEX_PARAM)
# define YYLEX yylex(YYLEX_PARAM)
#else
# define YYLEX_DECL() yylex(void)
# define YYLEX yylex()
#endif

/* Parameters sent to yyerror. */
#ifndef YYERROR_DECL
#define YYERROR_DECL() yyerror(const char *s)
#endif
#ifndef YYERROR_CALL
#define YYERROR_CALL(msg) yyerror(msg)
#endif

extern int YYPARSE_DECL();

#define CADENA 257
#define SALTO 258
#define IDENTIFICADOR 259
#define ENTERO 260
#define REAL 261
#define BOOLEANO 262
#define DEINDENTA 263
#define INDENTA 264
#define AND 265
#define OR 266
#define NOT 267
#define WHILE 268
#define FOR 269
#define PRINT 270
#define ELIF 271
#define ELSE 272
#define IF 273
#define MAS 274
#define MENOS 275
#define POR 276
#define POTENCIA 277
#define DIV 278
#define DIVENTERA 279
#define MODULO 280
#define LE 281
#define GR 282
#define LEQ 283
#define GRQ 284
#define EQUALS 285
#define DIFF 286
#define EQ 287
#define PA 288
#define PC 289
#define DOBLEPUNTO 290
#define YYERRCODE 256
typedef short YYINT;
static const YYINT yylhs[] = {                           -1,
    0,    0,    1,    1,    1,    1,    2,    2,    4,    4,
    5,    5,    6,    8,    8,    9,    9,    3,   10,   10,
   11,   11,   12,    7,   13,   13,   15,   15,   14,   14,
   17,   17,   16,   16,   18,   18,   20,   20,   21,   21,
   21,   21,   21,   21,   19,   19,   23,   23,   23,   23,
   22,   22,   25,   25,   25,   25,   25,   25,   25,   25,
   24,   24,   24,   26,   26,   27,   27,   27,   27,   27,
   27,
};
static const YYINT yylen[] = {                            2,
    0,    1,    1,    1,    2,    2,    1,    1,    1,    1,
    7,    4,    4,    1,    4,    1,    2,    2,    1,    1,
    1,    3,    2,    1,    1,    2,    2,    3,    1,    2,
    2,    3,    2,    1,    1,    2,    2,    3,    1,    1,
    1,    1,    1,    1,    1,    2,    2,    2,    3,    3,
    1,    2,    2,    2,    2,    2,    3,    3,    3,    3,
    2,    2,    1,    1,    3,    1,    1,    1,    1,    1,
    3,
};
static const YYINT yydefred[] = {                         0,
   68,    3,   66,   67,   69,   70,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    4,    7,    8,    9,   10,
    0,    0,   19,   20,   24,    0,    0,    0,    0,   34,
    0,    0,    0,    0,    0,    0,   63,    0,   33,    0,
   23,    0,   61,   62,    0,    5,    6,    0,   18,   27,
    0,   31,    0,   39,   40,   43,   42,   41,   44,   37,
    0,   47,   48,    0,   53,   56,   54,   55,    0,    0,
    0,    0,   71,   22,   28,   32,   38,   49,   50,   57,
   60,   58,   59,   65,    0,   14,   13,    0,    0,    0,
   16,    0,    0,   15,   17,   11,
};
static const YYINT yydgoto[] = {                         14,
   15,   16,   17,   18,   19,   20,   21,   87,   92,   22,
   23,   24,   25,   26,   27,   28,   29,   30,   31,   32,
   60,   33,   34,   35,   36,   37,   38,
};
static const YYINT yysindex[] = {                       -97,
    0,    0,    0,    0,    0,    0,   20,   20,   20,   20,
   31,   31,   20,    0,  -78,    0,    0,    0,    0,    0,
 -280, -240,    0,    0,    0, -247,   20, -242,   20,    0,
 -153,   31, -264,   31,   21,   31,    0, -230,    0, -239,
    0, -235,    0,    0, -233,    0,    0,   20,    0,    0,
 -216,    0, -203,    0,    0,    0,    0,    0,    0,    0,
 -153,    0,    0, -262,    0,    0,    0,    0,   33,   31,
  -21,  -21,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -201,    0,    0, -196,  -40, -210,
    0,  -59,  -21,    0,    0,    0,
};
static const YYINT yyrindex[] = {                        85,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   86,    0,    0,    0,    0,    0,
 -167,    0,    0,    0,    0, -135,    0, -165,    0,    0,
 -244,    0, -176,    0, -217,    0,    0, -250,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -131,    0, -140,    0,    0,    0,    0,    0,    0,    0,
 -206,    0,    0, -146,    0,    0,    0,    0, -187,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,
};
static const YYINT yygindex[] = {                         0,
    0,  -15,  -18,    0,    0,    0,   -4,  -55,    0,    0,
    0,    0,    0,   65,    0,   13,    0,    0,   72,    0,
   54,   82,    0,   -9,    0,    0,    0,
};
#define YYTABLESIZE 319
static const YYINT yytable[] = {                         47,
   12,   43,   44,   40,   41,   42,   48,   64,   45,   62,
   63,   78,   79,   35,   64,   64,   88,   49,   50,   39,
   35,   35,   52,   64,   64,   64,   69,   64,   64,   64,
   64,   64,   64,   64,   64,   64,   64,   96,   64,   64,
   51,   53,   35,   74,   35,   35,   70,   51,   51,   75,
   71,   36,   86,   86,   72,   73,   51,   51,   36,   36,
   84,   76,   89,   51,   51,   51,   51,   51,   51,   51,
   52,   51,   51,   91,   86,   90,   95,   52,   52,   93,
   36,   45,   36,   36,    1,    2,   52,   52,   45,   45,
   21,   51,   29,   52,   52,   52,   52,   52,   52,   52,
   29,   52,   52,   61,   45,   45,   45,   45,   45,   45,
   45,   46,   45,   45,   77,   64,    0,   30,   46,   46,
    0,   29,   25,   29,   29,   30,   26,   54,   55,   56,
   57,   58,   59,    0,   46,   46,   46,   46,   46,   46,
   46,    0,   46,   46,    0,    0,   30,    0,   30,   30,
    0,   25,    0,   25,   25,   26,    0,   26,   26,    1,
    2,    3,    4,    5,    6,    0,    0,    0,    0,    7,
    8,    0,    9,    0,    0,   10,   11,   12,    1,   46,
    3,    4,    5,    6,    0,    0,    0,    0,    7,    8,
   13,    9,    0,    0,   10,   11,   12,    1,    0,    3,
    4,    5,    6,   94,    0,    0,    0,    7,    8,   13,
    9,    0,    0,   10,   11,   12,    1,    0,    3,    4,
    5,    6,    0,    0,    0,    0,    7,    8,   13,    9,
    0,    0,   10,   11,   12,    1,   85,    3,    4,    5,
    6,    0,    0,    0,    0,    7,    0,   13,    9,    0,
    0,    0,   11,   12,    0,    0,    0,   12,   12,   12,
   12,   12,   12,   12,    0,    0,   13,   12,   12,    0,
   12,    0,    0,   12,   12,   12,    1,    0,    3,    4,
    5,    6,    0,    0,    0,    0,    7,    1,   12,    3,
    4,    5,    6,   11,   12,    0,   65,    0,   66,   67,
   68,    0,    0,    0,   11,   12,    0,   13,   80,    0,
   81,   82,   83,    0,    0,    0,    0,    0,   13,
};
static const YYINT yycheck[] = {                         15,
    0,   11,   12,    8,    9,   10,  287,  258,   13,  274,
  275,  274,  275,  258,  265,  266,   72,  258,  266,    7,
  265,  266,  265,  274,  275,  276,   36,  278,  279,  280,
  281,  282,  283,  284,  285,  286,  287,   93,  289,  290,
  258,   29,  287,   48,  289,  290,  277,  265,  266,  266,
  290,  258,   71,   72,  290,  289,  274,  275,  265,  266,
   70,  265,  264,  281,  282,  283,  284,  285,  286,  287,
  258,  289,  290,   89,   93,  272,   92,  265,  266,  290,
  287,  258,  289,  290,    0,    0,  274,  275,  265,  266,
  258,   27,  258,  281,  282,  283,  284,  285,  286,  287,
  266,  289,  290,   32,  281,  282,  283,  284,  285,  286,
  287,  258,  289,  290,   61,   34,   -1,  258,  265,  266,
   -1,  287,  258,  289,  290,  266,  258,  281,  282,  283,
  284,  285,  286,   -1,  281,  282,  283,  284,  285,  286,
  287,   -1,  289,  290,   -1,   -1,  287,   -1,  289,  290,
   -1,  287,   -1,  289,  290,  287,   -1,  289,  290,  257,
  258,  259,  260,  261,  262,   -1,   -1,   -1,   -1,  267,
  268,   -1,  270,   -1,   -1,  273,  274,  275,  257,  258,
  259,  260,  261,  262,   -1,   -1,   -1,   -1,  267,  268,
  288,  270,   -1,   -1,  273,  274,  275,  257,   -1,  259,
  260,  261,  262,  263,   -1,   -1,   -1,  267,  268,  288,
  270,   -1,   -1,  273,  274,  275,  257,   -1,  259,  260,
  261,  262,   -1,   -1,   -1,   -1,  267,  268,  288,  270,
   -1,   -1,  273,  274,  275,  257,  258,  259,  260,  261,
  262,   -1,   -1,   -1,   -1,  267,   -1,  288,  270,   -1,
   -1,   -1,  274,  275,   -1,   -1,   -1,  257,  258,  259,
  260,  261,  262,  263,   -1,   -1,  288,  267,  268,   -1,
  270,   -1,   -1,  273,  274,  275,  257,   -1,  259,  260,
  261,  262,   -1,   -1,   -1,   -1,  267,  257,  288,  259,
  260,  261,  262,  274,  275,   -1,  276,   -1,  278,  279,
  280,   -1,   -1,   -1,  274,  275,   -1,  288,  276,   -1,
  278,  279,  280,   -1,   -1,   -1,   -1,   -1,  288,
};
#define YYFINAL 14
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 290
#define YYUNDFTOKEN 320
#define YYTRANSLATE(a) ((a) > YYMAXTOKEN ? YYUNDFTOKEN : (a))
#if YYDEBUG
static const char *const yyname[] = {

"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"CADENA","SALTO","IDENTIFICADOR",
"ENTERO","REAL","BOOLEANO","DEINDENTA","INDENTA","AND","OR","NOT","WHILE","FOR",
"PRINT","ELIF","ELSE","IF","MAS","MENOS","POR","POTENCIA","DIV","DIVENTERA",
"MODULO","LE","GR","LEQ","GRQ","EQUALS","DIFF","EQ","PA","PC","DOBLEPUNTO",0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"illegal-symbol",
};
static const char *const yyrule[] = {
"$accept : input",
"input :",
"input : aux0",
"aux0 : SALTO",
"aux0 : stmt",
"aux0 : aux0 SALTO",
"aux0 : aux0 stmt",
"stmt : simple_stmt",
"stmt : compound_stmt",
"compound_stmt : if_stmt",
"compound_stmt : while_stmt",
"if_stmt : IF test DOBLEPUNTO suite ELSE DOBLEPUNTO suite",
"if_stmt : IF test DOBLEPUNTO suite",
"while_stmt : WHILE test DOBLEPUNTO suite",
"suite : simple_stmt",
"suite : SALTO INDENTA auxstmt DEINDENTA",
"auxstmt : stmt",
"auxstmt : auxstmt stmt",
"simple_stmt : small_stmt SALTO",
"small_stmt : expr_stmt",
"small_stmt : print_stmt",
"expr_stmt : test",
"expr_stmt : test EQ test",
"print_stmt : PRINT test",
"test : or_test",
"or_test : and_test",
"or_test : aux2 and_test",
"aux2 : and_test OR",
"aux2 : aux2 and_test OR",
"and_test : not_test",
"and_test : aux7 not_test",
"aux7 : not_test AND",
"aux7 : aux7 not_test AND",
"not_test : NOT not_test",
"not_test : comparison",
"comparison : expr",
"comparison : aux4 expr",
"aux4 : expr comp_op",
"aux4 : aux4 expr comp_op",
"comp_op : LE",
"comp_op : GR",
"comp_op : EQUALS",
"comp_op : GRQ",
"comp_op : LEQ",
"comp_op : DIFF",
"expr : term",
"expr : aux8 term",
"aux8 : term MAS",
"aux8 : term MENOS",
"aux8 : aux8 term MAS",
"aux8 : aux8 term MENOS",
"term : factor",
"term : aux9 factor",
"aux9 : factor POR",
"aux9 : factor DIVENTERA",
"aux9 : factor MODULO",
"aux9 : factor DIV",
"aux9 : aux9 factor POR",
"aux9 : aux9 factor DIVENTERA",
"aux9 : aux9 factor MODULO",
"aux9 : aux9 factor DIV",
"factor : MAS factor",
"factor : MENOS factor",
"factor : power",
"power : atom",
"power : atom POTENCIA factor",
"atom : IDENTIFICADOR",
"atom : ENTERO",
"atom : CADENA",
"atom : REAL",
"atom : BOOLEANO",
"atom : PA test PC",

};
#endif

int      yydebug;
int      yynerrs;

int      yyerrflag;
int      yychar;
YYSTYPE  yyval;
YYSTYPE  yylval;

/* define the initial stack-sizes */
#ifdef YYSTACKSIZE
#undef YYMAXDEPTH
#define YYMAXDEPTH  YYSTACKSIZE
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 10000
#define YYMAXDEPTH  10000
#endif
#endif

#define YYINITSTACKSIZE 200

typedef struct {
    unsigned stacksize;
    YYINT    *s_base;
    YYINT    *s_mark;
    YYINT    *s_last;
    YYSTYPE  *l_base;
    YYSTYPE  *l_mark;
} YYSTACKDATA;
/* variables for the parser stack */
static YYSTACKDATA yystack;
#line 168 "src/main/byaccj/Parser.y"
private Flexer lexer;
/* Nodo Raiz del AST */
public Nodo raíz;

/* Comunicación con el analizador léxico */
private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
}

/* Reporta errores y para ejecución. */
public void yyerror (String error) {
   System.err.println ("Error sintáctico en la línea " + lexer.line());
   System.exit(1);
}

/* lexer es creado en el constructor. */
public Parser(Reader r) {
    lexer = new Flexer(r, this);
    yydebug = true;
}
#line 395 "y.tab.c"

#if YYDEBUG
#include <stdio.h>		/* needed for printf */
#endif

#include <stdlib.h>	/* needed for malloc, etc */
#include <string.h>	/* needed for memset */

/* allocate initial stack or double stack size, up to YYMAXDEPTH */
static int yygrowstack(YYSTACKDATA *data)
{
    int i;
    unsigned newsize;
    YYINT *newss;
    YYSTYPE *newvs;

    if ((newsize = data->stacksize) == 0)
        newsize = YYINITSTACKSIZE;
    else if (newsize >= YYMAXDEPTH)
        return YYENOMEM;
    else if ((newsize *= 2) > YYMAXDEPTH)
        newsize = YYMAXDEPTH;

    i = (int) (data->s_mark - data->s_base);
    newss = (YYINT *)realloc(data->s_base, newsize * sizeof(*newss));
    if (newss == 0)
        return YYENOMEM;

    data->s_base = newss;
    data->s_mark = newss + i;

    newvs = (YYSTYPE *)realloc(data->l_base, newsize * sizeof(*newvs));
    if (newvs == 0)
        return YYENOMEM;

    data->l_base = newvs;
    data->l_mark = newvs + i;

    data->stacksize = newsize;
    data->s_last = data->s_base + newsize - 1;
    return 0;
}

#if YYPURE || defined(YY_NO_LEAKS)
static void yyfreestack(YYSTACKDATA *data)
{
    free(data->s_base);
    free(data->l_base);
    memset(data, 0, sizeof(*data));
}
#else
#define yyfreestack(data) /* nothing */
#endif

#define YYABORT  goto yyabort
#define YYREJECT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR  goto yyerrlab

int
YYPARSE_DECL()
{
    int yym, yyn, yystate;
#if YYDEBUG
    const char *yys;

    if ((yys = getenv("YYDEBUG")) != 0)
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = YYEMPTY;
    yystate = 0;

#if YYPURE
    memset(&yystack, 0, sizeof(yystack));
#endif

    if (yystack.s_base == NULL && yygrowstack(&yystack) == YYENOMEM) goto yyoverflow;
    yystack.s_mark = yystack.s_base;
    yystack.l_mark = yystack.l_base;
    yystate = 0;
    *yystack.s_mark = 0;

yyloop:
    if ((yyn = yydefred[yystate]) != 0) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = YYLEX) < 0) yychar = YYEOF;
#if YYDEBUG
        if (yydebug)
        {
            yys = yyname[YYTRANSLATE(yychar)];
            printf("%sdebug: state %d, reading %d (%s)\n",
                    YYPREFIX, yystate, yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("%sdebug: state %d, shifting to state %d\n",
                    YYPREFIX, yystate, yytable[yyn]);
#endif
        if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
        {
            goto yyoverflow;
        }
        yystate = yytable[yyn];
        *++yystack.s_mark = yytable[yyn];
        *++yystack.l_mark = yylval;
        yychar = YYEMPTY;
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;

    YYERROR_CALL("syntax error");

    goto yyerrlab;

yyerrlab:
    ++yynerrs;

yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yystack.s_mark]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("%sdebug: state %d, error recovery shifting\
 to state %d\n", YYPREFIX, *yystack.s_mark, yytable[yyn]);
#endif
                if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
                {
                    goto yyoverflow;
                }
                yystate = yytable[yyn];
                *++yystack.s_mark = yytable[yyn];
                *++yystack.l_mark = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("%sdebug: error recovery discarding state %d\n",
                            YYPREFIX, *yystack.s_mark);
#endif
                if (yystack.s_mark <= yystack.s_base) goto yyabort;
                --yystack.s_mark;
                --yystack.l_mark;
            }
        }
    }
    else
    {
        if (yychar == YYEOF) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = yyname[YYTRANSLATE(yychar)];
            printf("%sdebug: state %d, error recovery discards token %d (%s)\n",
                    YYPREFIX, yystate, yychar, yys);
        }
#endif
        yychar = YYEMPTY;
        goto yyloop;
    }

yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("%sdebug: state %d, reducing by rule %d (%s)\n",
                YYPREFIX, yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    if (yym)
        yyval = yystack.l_mark[1-yym];
    else
        memset(&yyval, 0, sizeof yyval);
    switch (yyn)
    {
case 1:
#line 20 "src/main/byaccj/Parser.y"
	{raíz = yyval; System.out.println("Reconocimiento Exitoso");}
break;
case 2:
#line 21 "src/main/byaccj/Parser.y"
	{raíz = yystack.l_mark[0]; System.out.println("Reconocimiento Exitoso");}
break;
case 4:
#line 26 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 5:
#line 27 "src/main/byaccj/Parser.y"
	{}
break;
case 6:
#line 28 "src/main/byaccj/Parser.y"
	{}
break;
case 7:
#line 32 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 8:
#line 33 "src/main/byaccj/Parser.y"
	{}
break;
case 9:
#line 37 "src/main/byaccj/Parser.y"
	{}
break;
case 10:
#line 38 "src/main/byaccj/Parser.y"
	{}
break;
case 11:
#line 42 "src/main/byaccj/Parser.y"
	{}
break;
case 12:
#line 43 "src/main/byaccj/Parser.y"
	{}
break;
case 13:
#line 47 "src/main/byaccj/Parser.y"
	{}
break;
case 14:
#line 51 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 15:
#line 52 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[-1];}
break;
case 16:
#line 56 "src/main/byaccj/Parser.y"
	{}
break;
case 17:
#line 57 "src/main/byaccj/Parser.y"
	{}
break;
case 18:
#line 61 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[-1];}
break;
case 19:
#line 65 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 20:
#line 66 "src/main/byaccj/Parser.y"
	{}
break;
case 21:
#line 70 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 22:
#line 71 "src/main/byaccj/Parser.y"
	{}
break;
case 23:
#line 75 "src/main/byaccj/Parser.y"
	{}
break;
case 24:
#line 79 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 25:
#line 83 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 26:
#line 84 "src/main/byaccj/Parser.y"
	{}
break;
case 27:
#line 87 "src/main/byaccj/Parser.y"
	{}
break;
case 28:
#line 88 "src/main/byaccj/Parser.y"
	{}
break;
case 29:
#line 92 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 30:
#line 93 "src/main/byaccj/Parser.y"
	{}
break;
case 31:
#line 97 "src/main/byaccj/Parser.y"
	{}
break;
case 32:
#line 98 "src/main/byaccj/Parser.y"
	{}
break;
case 33:
#line 102 "src/main/byaccj/Parser.y"
	{}
break;
case 34:
#line 103 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 35:
#line 107 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 36:
#line 108 "src/main/byaccj/Parser.y"
	{}
break;
case 37:
#line 112 "src/main/byaccj/Parser.y"
	{}
break;
case 38:
#line 113 "src/main/byaccj/Parser.y"
	{}
break;
case 39:
#line 117 "src/main/byaccj/Parser.y"
	{}
break;
case 40:
#line 118 "src/main/byaccj/Parser.y"
	{}
break;
case 41:
#line 119 "src/main/byaccj/Parser.y"
	{}
break;
case 42:
#line 120 "src/main/byaccj/Parser.y"
	{}
break;
case 43:
#line 121 "src/main/byaccj/Parser.y"
	{}
break;
case 44:
#line 122 "src/main/byaccj/Parser.y"
	{}
break;
case 45:
#line 126 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 46:
#line 127 "src/main/byaccj/Parser.y"
	{ yystack.l_mark[-1].agregaHijoFinal(yystack.l_mark[0]); 
                ; yyval = yystack.l_mark[-1]; }
break;
case 47:
#line 130 "src/main/byaccj/Parser.y"
	{ yyval = new AddNodo(yystack.l_mark[-1],null);}
break;
case 48:
#line 131 "src/main/byaccj/Parser.y"
	{}
break;
case 49:
#line 132 "src/main/byaccj/Parser.y"
	{}
break;
case 50:
#line 133 "src/main/byaccj/Parser.y"
	{}
break;
case 51:
#line 137 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 52:
#line 138 "src/main/byaccj/Parser.y"
	{}
break;
case 53:
#line 140 "src/main/byaccj/Parser.y"
	{}
break;
case 54:
#line 141 "src/main/byaccj/Parser.y"
	{}
break;
case 55:
#line 142 "src/main/byaccj/Parser.y"
	{}
break;
case 56:
#line 143 "src/main/byaccj/Parser.y"
	{}
break;
case 57:
#line 144 "src/main/byaccj/Parser.y"
	{}
break;
case 58:
#line 145 "src/main/byaccj/Parser.y"
	{}
break;
case 59:
#line 146 "src/main/byaccj/Parser.y"
	{}
break;
case 60:
#line 147 "src/main/byaccj/Parser.y"
	{}
break;
case 61:
#line 150 "src/main/byaccj/Parser.y"
	{}
break;
case 62:
#line 151 "src/main/byaccj/Parser.y"
	{}
break;
case 63:
#line 152 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 64:
#line 155 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 65:
#line 156 "src/main/byaccj/Parser.y"
	{}
break;
case 66:
#line 160 "src/main/byaccj/Parser.y"
	{}
break;
case 67:
#line 161 "src/main/byaccj/Parser.y"
	{yyval = yystack.l_mark[0];}
break;
case 68:
#line 162 "src/main/byaccj/Parser.y"
	{}
break;
case 69:
#line 163 "src/main/byaccj/Parser.y"
	{}
break;
case 70:
#line 164 "src/main/byaccj/Parser.y"
	{}
break;
case 71:
#line 165 "src/main/byaccj/Parser.y"
	{}
break;
#line 878 "y.tab.c"
    }
    yystack.s_mark -= yym;
    yystate = *yystack.s_mark;
    yystack.l_mark -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("%sdebug: after reduction, shifting from state 0 to\
 state %d\n", YYPREFIX, YYFINAL);
#endif
        yystate = YYFINAL;
        *++yystack.s_mark = YYFINAL;
        *++yystack.l_mark = yyval;
        if (yychar < 0)
        {
            if ((yychar = YYLEX) < 0) yychar = YYEOF;
#if YYDEBUG
            if (yydebug)
            {
                yys = yyname[YYTRANSLATE(yychar)];
                printf("%sdebug: state %d, reading %d (%s)\n",
                        YYPREFIX, YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == YYEOF) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("%sdebug: after reduction, shifting from state %d \
to state %d\n", YYPREFIX, *yystack.s_mark, yystate);
#endif
    if (yystack.s_mark >= yystack.s_last && yygrowstack(&yystack) == YYENOMEM)
    {
        goto yyoverflow;
    }
    *++yystack.s_mark = (YYINT) yystate;
    *++yystack.l_mark = yyval;
    goto yyloop;

yyoverflow:
    YYERROR_CALL("yacc stack overflow");

yyabort:
    yyfreestack(&yystack);
    return (1);

yyaccept:
    yyfreestack(&yystack);
    return (0);
}
