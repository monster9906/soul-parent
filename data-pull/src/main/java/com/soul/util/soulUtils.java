package com.soul.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 符浩灵
 * @date 2020/6/9 17:41
 *  从国家数据统计局获取身份城市
 */
public class soulUtils {

    /**
     * 解析身份
     * @param map
     * @param url
     */
    public static void parseProvinceName(Map<String, Map<String, String>> map, String url) throws IOException {
        // 获取页面文档数据
        Document document = Jsoup.connect(url).get();

        // 获取页面所有body标签
        Elements tbody = document.getElementsByTag("tbody");

        //获取第五个标签
        Element element = tbody.get(4);

        // 拿到tbody标签下所有的子标签
        Elements childrens = element.children();

        // 当前页面的url
        String baseUri = element.baseUri();

        for (Element element1 : childrens) {
            Elements provincetrs = element1.getElementsByClass("provincetr");

            for (Element provincetr : provincetrs) {

                Elements tds = provincetr.getElementsByTag("td");
                for (Element td : tds) {

                    String provinceName = td.getElementsByTag("a").text();
                    String href = td.getElementsByTag("a").attr("href");

                    System.out.println(provinceName + "    " + baseUri + "/" + href);

                    map.put(provinceName, null);
                    /**
                     * 组装城市页面的URL，进入城市页面爬城市名称
                     */
                    parseCityName(map, baseUri + "/" + href, provinceName);
                }
            }
        }
    }

    /**
     * 解析城市名称
     * @param map
     * @param url
     * @param provinceName
     * @throws IOException
     */
    public static void parseCityName(Map<String, Map<String, String>> map, String url, String provinceName) throws IOException {

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByTag("tbody");
        Element element = elements.get(4);
        Elements childrens = element.children();

        /**
         *
         */
        String baseUri = element.baseUri();
        Map<String, String> cityMap = new HashMap<>();

        for (Element element1 : childrens) {

            Elements citytrs = element1.getElementsByClass("citytr");

            for (Element cityTag : citytrs) {
                Elements tds = cityTag.getElementsByTag("td");

                /**
                 * 直辖市，城市名就是本身
                 */
                String cityName = tds.get(1).getElementsByTag("a").text();

                if (cityName.equals("市辖区")) {
                    cityName = provinceName;
                }
                String href1 = tds.get(1).getElementsByTag("a").attr("href");

                System.out.println(cityName + " " + href1);

                cityMap.put(cityName, href1);
            }
        }
        map.put(provinceName, cityMap);
    }


    public static void main(String[] args) throws IOException {
        Map<String, Map<String, String>> map = new HashMap<>();
        parseProvinceName(map, "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018");
        System.out.println(map);
    }
}
