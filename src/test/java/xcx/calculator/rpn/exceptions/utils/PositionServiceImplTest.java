package xcx.calculator.rpn.exceptions.utils;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

public class PositionServiceImplTest {

    private PositionService positionService;

    @Before
    public void setUp() throws Exception {
        positionService = new PositionServiceImpl();
    }

    @Test
    public void setPositionIndexBuildHashMap() {
        // when
        positionService.setPositionIndex(0, "1");
        positionService.setPositionIndex(1, "2");
        Map<Integer, Integer> map = positionService.getPositionMap();
        // then
        assertEquals(2, map.size());
        assertSame(1, positionService.getPositionMap().get(0));
        assertSame(3, positionService.getPositionMap().get(1));
    }

    @Test
    public void getPositionIndexReturnIndexForPositionGiven() {
        // given
        positionService.setPositionIndex(0, "1");
        positionService.setPositionIndex(1, "2");
        Map<Integer, Integer> map = positionService.getPositionMap();
        // when
        Integer positionIndex = positionService.getPositionIndex(1);
        // then
        assertTrue(positionIndex.equals(3));
    }
}