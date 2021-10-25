package subway.stations;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SubwayLinesTest {

    @Test
    public void getLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));

        //when
        SubwayLines subwayLines = gson.fromJson(reader, SubwayLines.class);
        reader.close();

        //then
        Assertions.assertNotNull(subwayLines.A);
        Assertions.assertNotNull(subwayLines.A.get(0));
        Assertions.assertEquals("55", subwayLines.A.get(0));
        Assertions.assertNotNull(subwayLines.one);
        Assertions.assertNotNull(subwayLines.one.get(0));
        Assertions.assertEquals("418", subwayLines.one.get(0));
        Assertions.assertNotNull(subwayLines.sixExpress);
        Assertions.assertNotNull(subwayLines.sixExpress.get(0));
        Assertions.assertEquals("29", subwayLines.sixExpress.get(0));

    }
}
