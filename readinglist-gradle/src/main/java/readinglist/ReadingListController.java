package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 组件扫描自动注册为一个Bean
@Controller
// 请求路径映射
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value="/{reader}", method = RequestMethod.GET)
    // 处理GET请求
    public String readersBooks(@PathVariable String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            // 设置books变量
            model.addAttribute("books", readingList);
        }
        // 返回readingList.html的模版
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    // 处理POST请求
    public String addToReadingList(@PathVariable String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
