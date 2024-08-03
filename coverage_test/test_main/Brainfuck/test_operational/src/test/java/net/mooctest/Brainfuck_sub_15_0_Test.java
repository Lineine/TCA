package net.mooctest;
import static org.junit.Assert.fail;
import java.io.PipedInputStream;
import net.mooctest.OokEngine.Token;
import java.io.InputStream;
import static org.junit.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import org.junit.Test;
import org.junit.After;
import java.io.PipedOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import static org.junit.Assert.assertFalse;
import java.io.ByteArrayOutputStream;
import org.junit.Before;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;
import java.io.BufferedInputStream;
import java.io.SequenceInputStream;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import org.dom4j.Branch;
import java.io.PushbackInputStream;
import org.junit.AfterClass;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.FileDescriptor;
import java.io.DataInputStream;
import java.io.PrintStream;
import org.junit.BeforeClass;
public class Brainfuck_sub_15_0_Test
{
    private String filePath = "src//main//resources//net//mooctest//demo.txt";
    @Test
    public void test_529() throws Exception {
        TrollScriptEngine trollScriptEngine0 = new TrollScriptEngine(0);
        boolean boolean0 = trollScriptEngine0.isValidToken("llo");
        assertTrue(boolean0);
    }
    
    @Test
    public void test_1988() throws Exception {
        TrollScriptEngine tse=new TrollScriptEngine(10);
        tse.interpret("avadsdafasfdq1 adaE das 12323");
        tse.interpret("avadsdafasf");
        tse.interpret("");
        tse.interpret("a");
        tse.interpret("tro");
        tse.interpret("ooo");
        tse.interpret("ool");
        tse.interpret("olo");
        tse.interpret("oll");
        tse.interpret("loo");
        tse.interpret("lol");
        tse.interpret("llo");
        tse.interpret("lll");
        tse.interpret("ll.");
        tse.interpret("tro 1 2 4 3");
        tse.interpret("ooo");
        tse.interpret("ool");
        tse.interpret("olo");
        tse.interpret("oll");
        tse.interpret("loo");
        tse.interpret("lol");
        tse.interpret("llo");
        tse.interpret("lll");
        tse.interpret("ll.");
    }
    @Test
    public void test_2093() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        byte[] byteArray0 = new byte[9];
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(byteArray0);
        TrollScriptEngine trollScriptEngine0 = new TrollScriptEngine(0, byteArrayOutputStream0, byteArrayInputStream0);
    }
    @Test
    public void test_1981() throws Exception {
        String data=Token.PLUS.value;
        InputStream testInput = new ByteArrayInputStream( data.getBytes());
        OutputStream out=new ByteArrayOutputStream(1024);
        OutputStream out1=new ByteArrayOutputStream(1024);
        OokEngine ok = new OokEngine(1,out1,testInput);
        PrintStream cacheStream = new PrintStream(out);
        PrintStream oldStream = System.out;
        System.setOut(cacheStream);
        try {
            ok.interpret("222");
            ok.interpret(Token.PLUS.value);
            ok.interpret(Token.MINUS.value);
            ok.interpret(Token.INPUT.value);
            ok.interpret(Token.PREVIOUS.value);
        ok.interpret('a',new char[]{'a'});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
        ok.interpret('>',new char[]{'a'});
        ok.interpret('<',new char[]{'a'});
        ok.interpret('=',new char[]{'a'});
        ok.interpret('+',new char[]{'a'});
        ok.interpret('-',new char[]{'a'});
        ok.interpret('.',new char[]{'a'});
        ok.interpret(',',new char[]{'a'});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TrollScriptEngine to=new TrollScriptEngine(1, out1,testInput);
        try {
            to.interpret("222");
            to.interpret("troooooolollloolol");
            to.interpret("ooo");
            to.interpret("olo");
            to.interpret("ool");
            to.interpret("oll");
            to.interpret("loo");
            to.interpret("lol");
            to.interpret("ll.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0, ok.dataPointer);
        assertEquals(0, ok.charPointer);
        assertEquals(9, ok.defaultTokenLength);
        try {
            ok.interpret(Token.PREVIOUS.value+Token.BRACKET_LEFT.value);
            ok.interpret(Token.BRACKET_RIGHT.value);
        } catch (Exception e) {
        }
        String strMsg = out.toString();
        System.setOut(oldStream);
        assertEquals(69,strMsg.length());
        new TrollScriptEngine(3,out);
        new TrollScriptEngine(4);
        new OokEngine(3, out1);
        BrainfuckEngine b1=new BrainfuckEngine(3);
        b1.initate(4);
        try {
            b1.interpret("33");
        } catch (Exception e) {
        }
        new BrainfuckEngine(3,out);
    }
    @Test
    public void test_2225() throws Exception {
        OokEngine ookEngine3 = new OokEngine(0);
        ookEngine3.interpret("Ook! Ook? Ook. Ook? Ook! Ook. 2  5 4");
    }
    
    @Test
    public void test_187() throws Exception {
        OokEngine ookEngine = new OokEngine(0);
        String src = "C:\\mooctest\\projects\\2526\\42964\\Brainfuck\\src\\main\\resources\\net\\mooctest\\demo.txt";
        BrainfuckEngine bf = new BrainfuckEngine(6);
        bf.interpret(src);
        ookEngine.interpret("C:\\mooctest\\projects\\2526\\42964\\Brainfuck\\src\\main\\resources\\net\\mooctest\\demo.txt");
        assertEquals(0, bf.dataPointer);
        assertEquals(0, ookEngine.charPointer);
        ookEngine.interpret("Ook. Ook?");
        assertEquals(0,ookEngine.dataPointer);
    }
    @Test
    public void test_2242() throws Exception {
        BrainfuckEngine bra1= new BrainfuckEngine(25);
        BrainfuckEngine bra2= new BrainfuckEngine(25,null);
        bra1.interpret("text");
        bra1.interpret("src/main/resources/demo.txt");
    char[] charr= {'>','<','+','-','.','[',']'};
        bra1.interpret('+',charr);
        bra1.interpret('>',charr);
        bra1.interpret('<',charr);
        bra1.interpret('[',charr);
    }
}