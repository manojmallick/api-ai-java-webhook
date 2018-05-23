package hello;


import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/movieHook")
public class SecondHelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponseModified movieHook(@RequestBody String obj) throws JAXBException {
        Gson gson=new Gson();
        JsonObject jsonObject=new JsonParser().parse(obj).getAsJsonObject();



//        String jsonArray= jsonObject.get("displayText").toString();
//
//        System.out.println("jsonArray"+jsonArray);
//
//
//        String modified=jsonArray.replaceAll("\\\\","");
//        System.out.println("modified"+modified);
//         gson=new Gson();
//      gson.fromJson(modified,Object.class);


     //   List<Movie>  movies1= (List<Movie>) gson.fromJson(jsons,List.class);
        WeatherRequest weatherRequest=null;
//        WeatherRequestWithAddress weatherRequestWithAddress=null;
//        try {
//            weatherRequest = gson.fromJson(obj, WeatherRequest.class);
//        } catch ( Exception e){
//            weatherRequestWithAddress = gson.fromJson(obj, WeatherRequestWithAddress.class);
//        }
//        JsonObject jsonObject=new JsonParser().parse(obj).getAsJsonObject();
//        System.out.println(jsonObject.get("result").getAsJsonObject().get("resolvedQuery"));
//        System.out.println(jsonObject.get("result").getAsJsonObject().get("action"));
//        System.out.println(jsonObject.get("result").getAsJsonObject().get("parameters"));
        List<Movie> movies= new BasicWebCrawler().getPageLinks("https://www.imdb.com/search/title?genres=action&title_type=feature&num_votes=25000,&sort=year,desc&year=2010");



        String speach="movieHook response";
      //  YahooWeatherService service = new YahooWeatherService();
        String action="";
        String typeOfDay;
        switch (action) {
            case "weather":
            case "weather.temperature":



                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
               // throw new IllegalArgumentException("Invalid action: " + action);
        }
        Gson gson1=new Gson();

        String json=gson1.toJson(movies);
        System.out.println(json);
        Messages messages=new Messages();
        messages.setType(4);
        Movies moviesList=new Movies();
        moviesList.setMovies(movies);
        messages.setPayLoad(moviesList);
        messages.setPayLoad(moviesList);
        Messages [] messages1=new Messages[1];
        messages1[0]=messages;
        WebhookResponseModified webhookResponseModified=new WebhookResponseModified("movie response","movie list");
        webhookResponseModified.setMessages(messages1);

        return webhookResponseModified;
    }

//    private Forecast findTemperatureData(List<Forecast> forecasts ,String dateTime) {
//        SimpleDateFormat format =
//                new SimpleDateFormat("dd MMM yyyy");
//        SimpleDateFormat old =
//                new SimpleDateFormat("yyyy-MM-dd");
//        Forecast forecastExpected=null;
//        try {
//            Date parsed = old.parse(dateTime);
//            String date=format.format(parsed);
//            for (Forecast forecast:forecasts
//                    ) {
//               if(forecast.getDate().compareTo(parsed)==0){
//                   forecastExpected=forecast;
//                   break;
//               }
//
//
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//        return forecastExpected;
//    }


//    private void mapcity(String city, WeatherRequest weatherRequest) {
//        if(city==null||city.equalsIgnoreCase("")){
//            city=weatherRequest.getResult().getParameters().getAddress().getAdminArea();
//            if(city==null||city.equalsIgnoreCase("")){
//                city=weatherRequest.getResult().getParameters().getAddress().getBusinessName();
//            }
//            if(city==null||city.equalsIgnoreCase("")){
//                city=weatherRequest.getResult().getParameters().getAddress().getSubadminArea();
//            }
//        }
//        weatherRequest.getResult().getParameters().getAddress().setCity(city);
//    }

//    private void mapWeather(WeatherRequest weatherRequest,WeatherRequestWithAddress weatherRequestWithAddress){
//
//        weatherRequest=new WeatherRequest();
//        weatherRequest.setId(weatherRequestWithAddress.getId());
//        weatherRequest.setLang(weatherRequestWithAddress.getLang());
//        weatherRequest.setSessionId(weatherRequestWithAddress.getSessionId());
//        Result result=new Result();
//        result.setAction(weatherRequestWithAddress.getResult().getAction());
//        result.setContexts(weatherRequestWithAddress.getResult().getContexts());
//        result.setIntentName(weatherRequestWithAddress.getResult().getIntentName());
//        Parameters parameters=new Parameters();
//        parameters.setActivity(weatherRequestWithAddress.getResult().getParameters().getActivity());
//        parameters.setDateTime(weatherRequestWithAddress.getResult().getParameters().getDateTime());
//        parameters.setTemperature(weatherRequestWithAddress.getResult().getParameters().getTemperature());
//        parameters.setUnit(weatherRequestWithAddress.getResult().getParameters().getUnit());
//        Address address=new Address();
//        address.setCity(weatherRequestWithAddress.getResult().getParameters().getAddress());
//        result.setParameters(parameters);
//
//
//    }



}
