package coopon.manimaran.about_us_activity;

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

import coopon.manimaran.about_us_activity.adapter.ThirdPartyLibraryAdapter;
import coopon.manimaran.about_us_activity.model.ThirdPartyLibModel;

public class ThirdPartyLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_library);

        setTitle("Third Party Libraries");
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
            List<ThirdPartyLibModel> libModelList = new ArrayList<>();

            try {
                JSONObject obj = new JSONObject(jsonString);
                JSONArray libArray = obj.getJSONArray("third_party_library");

                for (int i = 0; i < libArray.length(); i++) {
                    JSONObject lib = libArray.getJSONObject(i);
                    String name = lib.getString("name");
                    String url = lib.getString("url");
                    String license = lib.getString("license");
                    String license_url = lib.getString("license_url");

                    libModelList.add(new ThirdPartyLibModel(name, url, license, license_url));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            ThirdPartyLibraryAdapter adapter = new ThirdPartyLibraryAdapter(this, libModelList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }


    }
}
