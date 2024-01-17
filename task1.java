//Задача 1.
//создание SQL-запроса
class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder whereClause = new StringBuilder();
        // Разбор JSON-строки с параметрами
        String[] paramsArray = PARAMS.replaceAll("[{}\"]", "").split(", ");
        // Построение части WHERE с использованием StringBuilder
        for (String param : paramsArray) {
            String[] keyValue = param.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

        // Добавление условия в WHERE, если значение не равно "null"
            if (!"null".equals(value)){
                whereClause.append(key).append("='").append(value).append("' and ");
            }
        }
        // Удаление последнего "and " из whereClause, если он не пустой
        if (whereClause.length() > 0) {
            whereClause.delete(whereClause.length() - 5, whereClause.length());
        }
        // Сборка итогового запроса
        String finalQuery = QUERY + whereClause.toString();

        return new StringBuilder(finalQuery);
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
}
