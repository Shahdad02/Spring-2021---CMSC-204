import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest {

    private GradeBook gb1, gb2;

    @BeforeEach
    void setUp() {

        gb1 = new GradeBook(5);
        gb2 = new GradeBook(5);

        gb1.addScore(45);
        gb1.addScore(80);

        gb2.addScore(25);
        gb2.addScore(50);
    }

    @AfterEach
    void tearDown() {
        gb1 = null;
        gb2 = null;
    }

    @Test
    void addScoreTest() {
        assertTrue(gb1.toString().equals("45.0 80.0 "));
        assertTrue(gb2.toString().equals("25.0 50.0 "));
    }

    @Test
    void testSum() {
        assertEquals(125, gb1.sum(), .0001);
        assertEquals(75, gb2.sum(), .0001);
    }

    @Test
    void testMinimum() {
        assertEquals(45, gb1.minimum(), .001);
        assertEquals(25, gb2.minimum(), .001);
    }

    @Test
    void finalScore() {
        assertEquals(80, gb1.finalScore(), .001);
        assertEquals(50, gb2.finalScore(), .001);
    }
}