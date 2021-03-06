package modelparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LeskovskijE on 6/28/2017.
 */
public class ParserFactory {
     /**
     * Creates XMLModelParcer or JSONModelParser object depending on file in arguments.
     * @return XMLModelParcer or JSONModelParser.
     */
    public AbstractModelParser getParser(String path){
        AbstractModelParser parser = null;
        Pattern patternXML = Pattern.compile(".*\\.xml");
        Matcher matcherXML = patternXML.matcher(path);
        Pattern patternJSON = Pattern.compile(".*\\.json");
        Matcher matcherJSON = patternJSON.matcher(path);
        if (matcherXML.matches()){
            parser = new XMLModelParser();
        } else if (matcherJSON.matches()) {
            parser = new JSONModelParser();
        }
        return parser;
    }
}
