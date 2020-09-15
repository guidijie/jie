package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.console.ConsoleGoodsTypeService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/goods")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class ConsoleGoodsController {

    @Autowired
    private ConsoleGoodsTypeService consoleGoodsTypeService;

    /**
     * 查询所有商品类型
     */
    @GetMapping("/findGoodsTypeAll")
    public ResponseMessage uploadUserImg() {
        List<GoodsType> goodsTypeAll = consoleGoodsTypeService.findGoodsTypeAll();
        return goodsTypeAll != null ?
                ResponseMessage.success().addObject("goodsType",goodsTypeAll) :
                ResponseMessage.error().addObject("msg","出错了");
    }

    /**
     * 添加goods
     */
    @GetMapping("/addGoods")
    public ResponseMessage addGoods(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "price", required = false) String price,
                                    @RequestParam(value = "preferential", required = false) String preferential,
                                    @RequestParam(value = "grade", required = false) String grade,
                                    @RequestParam(value = "typeName", required = false) String typeName,
                                    @RequestParam(value = "goodsImg", required = false) String goodsImg,
                                    @RequestParam(value = "introduction", required = false) String introduction,
                                    @RequestParam(value = "details", required = false) String details,
                                    @RequestParam(value = "directory", required = false) String directory,
                                    @RequestParam(value = "delivery", required = false) String delivery,
                                    @RequestParam(value = "file", required = false) MultipartFile file,
                                    HttpServletRequest request) throws IOException {

        String imagesPath = uploadImag(file);



        return null;
//        return goodsTypeAll != null ?
//                ResponseMessage.success().addObject("goodsType",goodsTypeAll) :
//                ResponseMessage.error().addObject("msg","出错了");
    }


    private static String uploadImag(MultipartFile file) throws IOException {
        //获取前端上传的文件名称
        String multifilename = file.getOriginalFilename();
        //取文件名下标，给文件重命名的时候使用
        String suffix = multifilename.substring(multifilename.indexOf("."));
        //取一个随机id给文件重命名使用
        String uuid = UUID.randomUUID().toString();
        //你的接收的文件新的名字
        String filename = uuid + suffix;
        //获取项目的绝对路径
        String uri = System.getProperty("user.dir");
        //在项目新建一个 你重新生成名称的文件
        File file1 = new File(uri + "\\src\\main\\resources\\static\\images\\goodsImage", filename);

        //将接收的到的 multipartFile 类型的文件 转为 file
        file.transferTo(file1);
        //获取接收到的并存在项目本地的文件，这样你就可以拿着这个文件随意处理啦
        String filePath = file1.getAbsolutePath();
        String Path = "\\images\\goodsImage\\";
        return Path + filename;
    }
}
