package orgbonfantij16.asmsa.compsci.scholarshipapplicationapplication;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ItemAdapter itemAdapter;
    Context thisContext;
    ListView myListView;
    TextView progressTextView;
    List<String> scholarships = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        progressTextView = (TextView) findViewById(R.id.progressTextView);
        thisContext = this;

        progressTextView.setText("");
        Button btn = (Button) findViewById((R.id.getDataButton));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData retrieveData = new GetData();
                retrieveData.execute("");
            }
        });
    }

    private class GetData extends AsyncTask<String, String, String> {

        String msg = "";
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://" +
                DBStrings.DATABASE_URL + "/" +
                DBStrings.DATABASE_NAME;

        @Override
        protected void onPreExecute() {
            progressTextView.setText("Connecting to database...");
        }

        @Override
        protected String doInBackground(String... strings) {
            Connection conn = null;
            Statement stmt = null;

            try {
                /*Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DBStrings.USERNAME, DBStrings.PASSWORD);

                stmt = conn.createStatement();
                String sql = "SELECT `scholarship` FROM `scholarships`";
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()) {
                    String name = rs.getString("scholarship");

                    scholarships.add(name);
                }*/

                scholarships.add("Arkansas Gambling Scholarship");
                scholarships.add("Dean's Straight C Student Scholarship");
                scholarships.add("Scholarship Making Scholarship");
                scholarships.add("Arkansas Because you can Football Scholarship");
                scholarships.add("Arkansas' Louisiana Scholarship");
                scholarships.add("Scholarship Making Scholarship for Scholarship Making Scholarship");
                scholarships.add("The Meta Scholarship");
                scholarships.add("End of the list Scholarship");

                msg = "Process complete.";

                //rs.close();
                //stmt.close();
                //conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } /*catch (SQLException connError) {
                msg = "An exception was thrown for JDBC.";
                connError.printStackTrace();
            } catch (ClassNotFoundException e) {
                msg = "A class not found exception was thrown.";
                e.printStackTrace();
            } finally {
                try {
                    if(stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if(conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
            return null;
        }

        @Override
        protected void onPostExecute(String msg) {
            progressTextView.setText(this.msg);

            if(scholarships.size() > 0) {
                itemAdapter = new ItemAdapter(thisContext, scholarships);
                myListView.setAdapter(itemAdapter);
            }
        }
    } //End GetData
} //End MainActivity
