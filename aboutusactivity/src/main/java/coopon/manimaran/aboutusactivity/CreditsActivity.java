package coopon.manimaran.aboutusactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import coopon.manimaran.aboutusactivity.adapter.CreditsAdapter;
import coopon.manimaran.aboutusactivity.adapter.ThirdPartyLibraryAdapter;
import coopon.manimaran.aboutusactivity.model.CreditsModel;
import coopon.manimaran.aboutusactivity.model.ThirdPartyLibModel;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        setTitle("Credits");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("json_res_id")) {

            InputStream is = getResources().openRawResource(bundle.getInt("json_res_id"));
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jsonString = writer.toString();
            List<CreditsModel> creditsModelList = new ArrayList<>();

            try {
                JSONObject obj = new JSONObject(jsonString);
                JSONArray libArray = obj.getJSONArray("credits");

                for (int i = 0; i < libArray.length(); i++) {
                    JSONObject lib = libArray.getJSONObject(i);
                    String name = lib.getString("name");
                    String about = lib.getString("about");
                    String url = lib.getString("url");

                    creditsModelList.add(new CreditsModel(name, about, url));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            CreditsAdapter adapter = new CreditsAdapter(this, creditsModelList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }


    }
}
