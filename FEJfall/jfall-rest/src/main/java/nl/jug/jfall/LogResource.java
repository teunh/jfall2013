package nl.jug.jfall;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Path("log")
public class LogResource {

    private static final Logger logger = Logger.getGlobal();

    @POST
    public void putJson(@FormParam("timestamp") Date timestamp,  @FormParam("level") String level,  @FormParam("message")  String message) {
        Level logLevel = Level.parse(level);
        LogRecord record = new LogRecord(logLevel, message);
        record.setMillis(Long.valueOf(timestamp.getTime()));
        logger.log(record);
    }
}
