
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.capton.test.mvp.Model;
import com.capton.test.mvp.Presenter;

import java.util.Map;

/**
 * Model 实现类 ，采用Volley框架请求数据
 * Created by capton on 2018/4/13.
 */

public class DynamicModel extends Model {

    RequestQueue queue;

    public DynamicModel(Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getData(Context context, Map<String, Object> paramMap, final String tag) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest((String)paramMap.get("url"), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dataGot(response,tag);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataGoterror(error.toString(),tag);
            }
        });
        queue.add(request);
    }

}
