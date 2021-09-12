package com.codechef.dsa.learning.series;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PrintStarsTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStars ps = new PrintStars();

    @BeforeEach
    public void setUpStreams() throws IOException {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void shouldPrintStarsReverse() {
        ps.reverse(4);
        try (ByteArrayInputStream in = new ByteArrayInputStream(outContent.toByteArray());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));) {
            Assertions.assertEquals("   *", br.readLine());
            Assertions.assertEquals("  **", br.readLine());
            Assertions.assertEquals(" ***", br.readLine());
            Assertions.assertEquals("****", br.readLine());
            Assertions.assertEquals(-1, br.read());
        } catch (Exception e) {
            Assertions.fail("Exception Occurred while reversing");
        }
    }

    @Test
    void shouldPrintStarsForward() {
        ps.forward(4);
        try (ByteArrayInputStream in = new ByteArrayInputStream(outContent.toByteArray());
                BufferedReader br = new BufferedReader(new InputStreamReader(in));) {
            Assertions.assertEquals("*   ", br.readLine());
            Assertions.assertEquals("**  ", br.readLine());
            Assertions.assertEquals("*** ", br.readLine());
            Assertions.assertEquals("****", br.readLine());
            Assertions.assertEquals(-1, br.read());
        } catch (Exception e) {
            Assertions.fail("Exception Occurred while reversing");
        }
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}