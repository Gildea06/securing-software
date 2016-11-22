package sec.notebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotebookController {
    private List<String> data;

    public NotebookController() {
        this.data = new ArrayList<>();
        //this.data.add("Hello world!");
    }

    @RequestMapping(value = "/")
    public String home(Model model, @RequestParam(required = false) String content) {
        if (content != null && !content.trim().isEmpty()) {
            this.data.add(content);
        }

        model.addAttribute("list", data);

        if (this.data.size() > 10) {
            HashMap map = (HashMap) model.asMap();
            List<String> mapList = (List<String>) map.get("list");
            int originalSize = this.data.size() - 1;
            List<String> topTen = new ArrayList();
            for (int index = originalSize; index > originalSize - 10; index--) {
                topTen.add(mapList.get(index));
            }
            model.addAttribute("list", topTen);
        }

        return "index";
    }
}
