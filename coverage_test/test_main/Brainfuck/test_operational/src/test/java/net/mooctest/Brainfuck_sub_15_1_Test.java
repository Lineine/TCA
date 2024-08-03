package net.mooctest;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import java.io.PipedInputStream;
import java.io.InputStream;
import java.io.*;
import org.junit.runner.RunWith;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.BufferedInputStream;
import org.junit.Test;
import java.io.SequenceInputStream;
public class Brainfuck_sub_15_1_Test
{
    
    @Test
    public void test_244() throws Exception {
        TrollScriptEngine trollScriptEngine = new TrollScriptEngine(0);
        TrollScriptEngine trollScriptEngine1 = new TrollScriptEngine(1024);
        String troinstruction = "troll.";
        String troinstruction1 = "trooooll.";
        String troinstruction2 = "trooolll.";
        String troinstruction3 = "ooloolooloolooloolool";
        String troinstruction4 = "ooooooooooooooooooooo";
        String troinstruction5 = "trooloollloollolllll.";
        trollScriptEngine.interpret(troinstruction);
        trollScriptEngine.interpret(troinstruction1);
        trollScriptEngine.interpret(troinstruction2);
        trollScriptEngine.interpret(troinstruction3);
        trollScriptEngine.interpret(troinstruction4);
        trollScriptEngine1.interpret(troinstruction5);
    }
}