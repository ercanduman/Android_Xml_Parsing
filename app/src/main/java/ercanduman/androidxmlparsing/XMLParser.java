package ercanduman.androidxmlparsing;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class XMLParser {
    private static boolean inDataItemTag = false;
    private static String currentTag;
    private static Horoscope horoscope;

    public static Horoscope parseFeed(String content) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(content));

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTag = parser.getName();
                        if (currentTag.equals("item")) {
                            inDataItemTag = true;
                            horoscope = new Horoscope();
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            inDataItemTag = false;
                        }
                        currentTag = "";
                        break;

                    case XmlPullParser.TEXT:
                        if (inDataItemTag && horoscope != null) {
                            switch (currentTag) {
                                case "title":
                                    horoscope.setTitle(parser.getText());
                                    break;
                                case "description":
                                    horoscope.setDescription(parser.getText());
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                }
                eventType = parser.next();
            }
            return horoscope;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
