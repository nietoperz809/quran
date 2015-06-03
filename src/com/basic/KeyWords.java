/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic;

/**
 *
 * @author Administrator
 */
public enum KeyWords
{
    NONE("*NONE*"),
    GOTO("goto"),
    GOSUB("gosub"),
    RETURN("return"),
    PRINT("print"),
    IF("if"),
    THEN("then"),
    END("end"),
    DATA("data"),
    RESTORE("restore"),
    READ("read"),
    ON("on"),
    REM("rem"),
    FOR("for"),
    TO("to"),
    NEXT("next"),
    STEP("step"),
    ON_GOSUB("gosub"),
    ON_GOTO("goto"),
    LET("let"),
    INPUT("input"),
    STOP("stop"),
    DIM("dim"),
    RANDOMIZE("randomize"),
    TRON("tron"),
    TROFF("troff"),
    TIMER("timer"), // not a real statement
    CLS("cls"),
    SLEEP("sleep"),
    TWEET("tweet"),
    SEQ("seq"),
    SCLR("sclr"),
    SPLAY("splay"),
    SSPEED("sspeed"),
    NOTES("notes"),
    SPEAK("say"),
    PITCH("pitch"),
    RATE("rate");

    private final String text;

    /**
     * @param text
     */
    private KeyWords(final String text)
    {
        this.text = text;
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
