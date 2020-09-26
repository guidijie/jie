package com.jie.stupiddog.controller.console;


import com.jie.stupiddog.pojo.Goods;
import com.jie.stupiddog.pojo.GoodsAndImages;
import com.jie.stupiddog.pojo.GoodsIdAndGoodsType;
import com.jie.stupiddog.pojo.GoodsType;
import com.jie.stupiddog.service.console.ConsoleGoodsAndGoodsTypeService;
import com.jie.stupiddog.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/goods")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
public class ConsoleGoodsController {

    @Autowired
    private ConsoleGoodsAndGoodsTypeService consoleGoodsTypeService;

    /**
     * 查询所有商品类型
     */
    @GetMapping("/findGoodsTypeAll")
    public ResponseMessage uploadUserImg() {
        List<GoodsType> goodsTypeAll = consoleGoodsTypeService.findGoodsTypeAll();
        return goodsTypeAll != null ?
                ResponseMessage.success().addObject("goodsType", goodsTypeAll) :
                ResponseMessage.error().addObject("msg", "出错了");
    }

    /**
     * 添加goods
     */
    @PostMapping("/addGoods")
    public ResponseMessage addGoods(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "price", required = false) Double price,
                                    @RequestParam(value = "preferential", required = false) Double preferential,
                                    @RequestParam(value = "grade", required = false) String grade,
                                    @RequestParam(value = "goodsTypeId", required = false) int goodsTypeId,
                                    @RequestParam(value = "introduction", required = false) String introduction,
                                    @RequestParam(value = "details", required = false) String details,
                                    @RequestParam(value = "directory", required = false) String directory,
                                    @RequestParam(value = "file", required = false) MultipartFile file,
                                    HttpServletRequest request) throws IOException {

        String imagesPath = uploadImag(file);
        Goods goods = new Goods(name, price, preferential, grade, introduction, details, directory, new Date(), new Date(), imagesPath);
        int num = consoleGoodsTypeService.addGoods(goods);
        if (num > 0) {
            GoodsIdAndGoodsType g = new GoodsIdAndGoodsType(goods.getId(), goodsTypeId);
            int i = consoleGoodsTypeService.giveGoodsAddGoodsType(g);
            return i > 0 ?
                    ResponseMessage.success().addObject("msg", "商品添加成功") :
                    ResponseMessage.error().addObject("msg", "出错了");
        }
        System.out.println(imagesPath);

        return ResponseMessage.error();

    }


    /**
     * 添加商品类型
     */
    @PostMapping("/addGoodsType")
    public ResponseMessage addGoodsType(@RequestBody GoodsType goodsType) {
        goodsType.setCreationtime(new Date());
        goodsType.setModifytime(new Date());
        int num = consoleGoodsTypeService.addGoodsType(goodsType);
        return num > 0 ?
                ResponseMessage.success().addObject("msg", "商品类型添加成功") :
                ResponseMessage.error().addObject("msg", "出错了");

    }

    /**
     * 修改商品类型
     */
    @PostMapping("/updateGoodsType")
    public ResponseMessage updateGoodsType(@RequestBody GoodsType goodsType) {

        goodsType.setModifytime(new Date());
        int num = consoleGoodsTypeService.updateGoodsType(goodsType);
        return num > 0 ?
                ResponseMessage.success().addObject("msg", "商品类型修改成功") :
                ResponseMessage.error().addObject("msg", "出错了");

    }

    /**
     * 查询所有商品
     */
    @GetMapping("/findGoodsAll/{num}")
    public ResponseMessage findGoodsAll(@PathVariable String num) {
        Integer pageNum = Integer.valueOf(num);
        final Map<String, Object> goodsAll = consoleGoodsTypeService.findGoodsAll(pageNum);
        return goodsAll != null  ?
                ResponseMessage.success().addObject("goods", goodsAll) :
                ResponseMessage.error().addObject("msg", "出错了");

    }

    /**
     * 根据goodsId更新goods
     * */
    @PostMapping("/updateGoods")
    public ResponseMessage updateGoods(@RequestBody Goods goods) {
        goods.setModifytime(new Date());
        int num = consoleGoodsTypeService.updateGoods(goods);
        return num > 0 ?
                ResponseMessage.success().addObject("msg", "修改成功") :
                ResponseMessage.error().addObject("msg", "出错了");

    }

    /**
     * 根据goodsId删除goods
     * */
    @GetMapping("/deleteGoods/{goodsId}")
    public ResponseMessage deleteGoods(@PathVariable int goodsId) {
        int num1 = consoleGoodsTypeService.deleteGoods(goodsId);
        int num2 = consoleGoodsTypeService.deleteGoodsIdType(goodsId);

        return (num1 > 0 && num2 >0 ) ?
                ResponseMessage.success().addObject("msg", "删除成功") :
                ResponseMessage.error().addObject("msg", "出错了");
    }

    /**
     * 批量删除goods
     * */
    @PostMapping("/deleteGoodsList")
    public ResponseMessage deleteGoodsList(@RequestBody List<Goods> goodsList) {
        int num1 = consoleGoodsTypeService.deleteGoodsList(goodsList);
        int num2 = consoleGoodsTypeService.deleteGoodsIdTypeList(goodsList);

        return (num1 > 0 && num2 >0 ) ?
                ResponseMessage.success().addObject("msg", "删除成功") :
                ResponseMessage.error().addObject("msg", "出错了");
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
