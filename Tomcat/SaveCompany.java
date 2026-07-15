import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.mongodb.client.*;
import org.bson.Document;
public class SaveCompany extends HttpServlet {
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String company = request.getParameter("company");
        String city = request.getParameter("city");
        int estd = Integer.parseInt(request.getParameter("estd"));
        try {
            String uri = "mongodb+srv://xyzsujal536_db_user:XiMe6hpFdFwMhhEr@courseplatform.pbhaka7.mongodb.net/companydb?retryWrites=true&w=majority&appName=Courseplatform";
            MongoClient client = MongoClients.create(uri);
            MongoDatabase database = client.getDatabase("companydb");
            MongoCollection<Document> collection = database.getCollection("company");
            Document doc = new Document("company_name", company)
                    .append("city", city)
                    .append("estd", estd);
            collection.insertOne(doc);
            out.println("<h2>Record Saved Successfully!</h2>");
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error:</h3>");
            out.println(e.getMessage());
        }
    }}