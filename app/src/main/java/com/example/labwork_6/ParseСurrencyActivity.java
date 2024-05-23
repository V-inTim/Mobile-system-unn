package com.example.labwork_6;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labwork_6.adapters.CurrencyItemAdapter;
import com.example.labwork_6.models.CurrencyItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ParseСurrencyActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_currenty_activity);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<ArrayList<CurrencyItem>> future = executorService.submit(()->
                parseXmlFromUrl("https://www.cbr.ru/scripts/XML_daily.asp"));
        executorService.shutdown();
        try {
            ArrayList<CurrencyItem> items = future.get();
            CurrencyItemAdapter adapter =
                    new CurrencyItemAdapter(this, android.R.layout.simple_list_item_1, items);
            ListView listView = findViewById(R.id.currency_list);
            listView.setAdapter(adapter);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<CurrencyItem> parseXmlFromUrl(String urlString)  {
        ArrayList<CurrencyItem> items = new ArrayList<>();
        CurrencyItem currentItem = null;

        try {
            URL url = new URL(urlString);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(url.openStream());

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Valute");
            for(int i=0; i<nList.getLength(); i++){
                Element el = (Element) nList.item(i);
                String numCode = el.getElementsByTagName("NumCode").item(0).getTextContent();
                String charCode = el.getElementsByTagName("CharCode").item(0).getTextContent();
                int nominal = Integer.parseInt(el.getElementsByTagName("Nominal").item(0).getTextContent());
                String name = el.getElementsByTagName("Name").item(0).getTextContent();
                String value = el.getElementsByTagName("Value").item(0).getTextContent();
                String vunitRate = el.getElementsByTagName("VunitRate").item(0).getTextContent();
                items.add(new CurrencyItem(value, name));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
