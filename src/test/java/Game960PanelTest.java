package test.java;

import main.Game960Panel;
import main.Type;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import piece.*;

public class Game960PanelTest {

    @Test
    void testBackRankContainsAllPieceTypes() {
        Game960Panel panel = new Game960Panel();

        // Extract white back rank pieces at row 7
        List<Piece> backRank = new ArrayList<>();
        for (Piece p : panel.getPieces()) {
            if (p.row == 7) {
                backRank.add(p);
            }
        }

        assertEquals(8, backRank.size(), "Back rank must contain 8 pieces");

        // Count piece types
        long rooks = backRank.stream().filter(p -> p.type == Type.ROOK).count();
        long knights = backRank.stream().filter(p -> p.type == Type.KNIGHT).count();
        long bishops = backRank.stream().filter(p -> p.type == Type.BISHOP).count();
        long queens = backRank.stream().filter(p -> p.type == Type.QUEEN).count();
        long kings = backRank.stream().filter(p -> p.type == Type.KING).count();

        assertEquals(2, rooks);
        assertEquals(2, knights);
        assertEquals(2, bishops);
        assertEquals(1, queens);
        assertEquals(1, kings);
    }


    @Test
    void testRandomizationProducesDifferentLayouts() {
        // Run the generator multiple times
        Set<String> layouts = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            Game960Panel panel = new Game960Panel();

            // Encode back rank layout as a string like: RNBQKBNR
            char[] row = new char[8];
            for (Piece p : panel.pieces) {
                if (p.row == 7) {
                    switch (p.type) {
                        case ROOK: row[p.col] = 'R'; break;
                        case KNIGHT: row[p.col] = 'N'; break;
                        case BISHOP: row[p.col] = 'B'; break;
                        case QUEEN: row[p.col] = 'Q'; break;
                        case KING: row[p.col] = 'K'; break;
                    }
                }
            }

            layouts.add(new String(row));
        }

        assertTrue(layouts.size() > 1,
                "Randomization should produce different Chess960 layouts");
    }
}