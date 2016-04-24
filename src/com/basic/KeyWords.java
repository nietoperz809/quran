/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic;

import java.util.EnumSet;

/**
 *
 * @author Administrator
 */
public enum KeyWords
{
    GOTO("goto", "jump to another line"),
    GOSUB("gosub", "jump to subroutine and save return"),
    RETURN("return", "returns from subroutine"),
    PRINT("print", "output text and variables"),
    IF("if", "tests condition and possibly do a branch"),
    THEN("then", "alternative path for if statement"),
    END("end", "end program execution"),
    DATA("data", "begin list of values"),
    RESTORE("restore", "resets internal data read pointer"),
    READ("read", "reads one value from data section and increments read pointer"),
    ON("on", "precedes goto or gosub statement"),
    ON_GOSUB("gosub", "on ... jump to subroutine condition"),
    ON_GOTO("goto", "on ... conditional jump"),
    REM("rem", "line comment"),
    FOR("for", "begins for loop"),
    TO("to", "before last value in for loop"),
    NEXT("next", "execute next looping"),
    STEP("step", "step with of for loop"),
    NAME ("name", "give this thread a name"),
    LET("let"),
    INPUT("input"),
    STOP("stop"),
    DIM("dim"),
    RANDOMIZE("randomize"),
    TRON("tron"),
    TROFF("troff"),
    TIMER("timer", "may be used for randomize"), // not a real statement
    CLS("cls"),
    SLEEP("sleep"),
    TWEET("tweet"),
    SEQ("seq"),
    SCLR("sclr"),
    SPLAY("splay"),
    SSPEED("sspeed"),
    NOTES("notes", "prints out midi notes"),
    SPEAK("say", "speak out a text"),
    PITCH("pitch", "set the speech pitch"),
    RATE("rate", "set the speech rate"),   // Must be last statement

    CMD_NEW("new"),
    CMD_RUN("run"),
    CMD_LIST("list"),
    CMD_CAT("cat"),
    CMD_DEL("del"),
    CMD_RESUME("resume"),
    CMD_BYE( "bye"),
    CMD_SAVE("save"),
    CMD_LOAD("load"),
    CMD_DUMP("dump"),
    CMD_CONT("cont"),
    CMD_INSTRLIST("instrlist"),
    CMD_CMDS("cmds"),
    CMD_DIR("dir"),
    
    RND("rnd", "get a random number"),
    INT("int"),
    SIN("sin"),
    COS("cos"),
    TAN("tan"),
    ATN("atn"),
    SQR("sqr"),
    MAX("max"),
    MIN("min"),
    ABS("abs"),
    GETNAME ("name$", "get the thread name"),
    TID("tid", "get the thread id"),
    LEFT("left$"),
    RIGHT("right$"),
    MID("mid$"),
    CHR("chr$"),
    LEN("len"),
    VAL("val"),
    SPC("spc$"),
    LOG("log"),
    FRE("fre"), // doesn't really do anything here.
    SGN("sgn"),
    TAB("tab"),
    STR("str$"),
    INKEYS("inkey$"),
    TIME("time"),
    
    OP_ADD("+"),   // Addition '+'
    OP_SUB("-"),   // Subtraction '-'
    OP_MUL("*"),   // Multiplication '*'
    OP_DIV("/"),   // Division '/'
    OP_EXP("**"),   // Exponentiation '**'
    OP_AND("&"),   // Bitwise AND '&'
    OP_IOR("|"),   // Bitwise inclusive OR '|'
    OP_XOR("^"),   // Bitwise exclusive OR '^'
    OP_NOT("!"),   // Unary negation '!'
    OP_EQ("="),  // Equality '='
    OP_NE("<>"),  // Inequality '<>'
    OP_LT("<"),  // Less than '<'
    OP_LE("<="),  // Less than or equal '<='
    OP_GT(">"),  // Greater than '>'
    OP_GE(">="),  // Greater than or equal '>='
    OP_BAND("AND"),  // Boolean AND '.AND.'
    OP_BIOR("OR"),  // Boolean inclusive or '.OR.'
    OP_BXOR("XOR"),  // Boolean exclusive or '.XOR.'
    OP_BNOT("NOT"),  // Boolean negation '.NOT.'
    OP_NEG("-"),  // Unary minus

    SYMBOL("symbol"),
    COMMAND("command"),
    CONSTANT("constant"),
    FUNCTION("function"),
    KEYWORD("keyword"),
    EOL("eol"),
    STRING("string"),
    ERROR("error"),
    STRING_VARIABLE("string variable"),
    BOOLEAN_OPERATOR("numeric variable"),
    OPERATOR("boolean operator"),
    VARIABLE("operator"),
    
    ENDLIST("");

    final public static EnumSet<KeyWords> keywords = EnumSet.range (GOTO, RATE);
    final public static EnumSet<KeyWords> commands = EnumSet.range (CMD_NEW, CMD_DIR);
    final public static EnumSet<KeyWords> functions = EnumSet.range (RND, TIME);
    final public static EnumSet<KeyWords> operators = EnumSet.range (OP_ADD, OP_NEG);
    final public static EnumSet<KeyWords> tokentype = EnumSet.range (SYMBOL, VARIABLE);
    
    private final String text;
    private final String desc;

    /**
     * @param text
     */
    KeyWords(final String text)
    {
        this.text = text;
        this.desc = null;
    }

    KeyWords(final String text, final String desc)
    {
        this.text = text;
        this.desc = desc;
    }

    public String getDesc()
    {
        return desc;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString()
    {
        return text;
    }
}
