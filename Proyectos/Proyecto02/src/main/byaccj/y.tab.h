/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

#ifndef YY_YY_Y_TAB_H_INCLUDED
# define YY_YY_Y_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    NUMERO = 258,
    TRUE = 259,
    FALSE = 260,
    SALTO = 261,
    AND = 262,
    FROM = 263,
    ENTERO = 264,
    REAL = 265,
    INDENTA = 266,
    DEINDENTA = 267,
    ELIF = 268,
    OR = 269,
    IF = 270,
    PRINT = 271,
    RETURN = 272,
    MAS = 273,
    MENOS = 274,
    MULT = 275,
    DIV = 276,
    EXP = 277,
    MOD = 278,
    MAYOR = 279,
    MENOR = 280,
    NOT = 281,
    WHILE = 282,
    FOR = 283,
    ELSE = 284,
    CADENA = 285,
    MAYORIG = 286,
    MENOSIG = 287,
    IGUAL = 288,
    DIST = 289,
    MASIG = 290,
    MENORIG = 291,
    IGUALIG = 292,
    PARIZQ = 293,
    PARDER = 294,
    DOSPUNTOS = 295,
    PUNTOCOMA = 296,
    IDENTIFICADOR = 297
  };
#endif
/* Tokens.  */
#define NUMERO 258
#define TRUE 259
#define FALSE 260
#define SALTO 261
#define AND 262
#define FROM 263
#define ENTERO 264
#define REAL 265
#define INDENTA 266
#define DEINDENTA 267
#define ELIF 268
#define OR 269
#define IF 270
#define PRINT 271
#define RETURN 272
#define MAS 273
#define MENOS 274
#define MULT 275
#define DIV 276
#define EXP 277
#define MOD 278
#define MAYOR 279
#define MENOR 280
#define NOT 281
#define WHILE 282
#define FOR 283
#define ELSE 284
#define CADENA 285
#define MAYORIG 286
#define MENOSIG 287
#define IGUAL 288
#define DIST 289
#define MASIG 290
#define MENORIG 291
#define IGUALIG 292
#define PARIZQ 293
#define PARDER 294
#define DOSPUNTOS 295
#define PUNTOCOMA 296
#define IDENTIFICADOR 297

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
