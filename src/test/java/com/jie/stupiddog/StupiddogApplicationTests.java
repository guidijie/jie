package com.jie.stupiddog;

import com.github.pagehelper.PageHelper;
import com.jie.stupiddog.dao.*;
import com.jie.stupiddog.pojo.*;
import com.jie.stupiddog.service.GoodsAndImagesService;
import com.jie.stupiddog.service.GoodsTypeService;
import com.jie.stupiddog.vo.GoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class StupiddogApplicationTests {

    @Resource
    public GoodsDao goodsDao;

    @Resource
    public GoodsImagesDao goodsImages;

    @Resource
    public GoodsIdAndGoodsTypeDao goodsIdAndGoodsTypeDao;

    @Resource
    public GoodsTypeDao goodsTypeDao;

    @Resource
    public GoodsTypeService goodsTypeService;

    @Resource
    public GoodsAndImagesDao goodsAndImagesDao;

    @Resource
    private UserDao userDao;


    @Test
    void testGoods() {
        List<Goods> goods = goodsDao.selectGrade();
        System.out.println(goods);
    }

    @Test
    void testGoodsImages() {

        List<GoodsImages> goodsImagesAll = goodsImages.findAll();
        for (GoodsImages s : goodsImagesAll) {
            System.out.println(s);

        }
    }

    @Test
    void testGoodsIdAndGoodsType() {

        List<GoodsIdAndGoodsType> goodsIdAndGoodsTypeDaoAll = goodsIdAndGoodsTypeDao.findAll();
        for (GoodsIdAndGoodsType s : goodsIdAndGoodsTypeDaoAll) {
            System.out.println(s);

        }

        System.out.println("================================");


    }

    @Test
    void testGoodsType() {

        Map<String, List<GoodsAndImages>> map = new HashMap<>();
        //查询所有商品类型
        List<GoodsType> goodsTypeDaoAll = goodsTypeDao.findAll();
        for (GoodsType s : goodsTypeDaoAll) {
            List<GoodsIdAndGoodsType> byGoodsTypeId = goodsTypeDao.findByGoodsTypeId(s.getId());
            for (GoodsIdAndGoodsType g : byGoodsTypeId) {
                //根据goodsId查询商品
                GoodsAndImages goodsAndImages = goodsDao.findById2(g.getGoodsId());
                //判断map中是否存在key
                if (map.containsKey(s.getTypeName())) {
                    List<GoodsAndImages> list = map.get(s.getTypeName());
                    list.add(goodsAndImages);
                } else {
                    List<GoodsAndImages> list2 = new ArrayList<>();
                    list2.add(goodsAndImages);
                    map.put(s.getTypeName(), list2);
                }
            }
        }

        for (Map.Entry<String, List<GoodsAndImages>> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    @Test
    void aa() {

        /*按照商品类型查询所有*/

        int pageNum = 2;
        String goodsType = "绘画";
        Map<String, Object> map = new HashMap<>();
        GoodsType g = goodsTypeDao.findByGoodsTypeName(goodsType);
        List<GoodsIdAndGoodsType> byGoodsTypeId = goodsTypeDao.findByGoodsTypeId(g.getId());
        PageHelper.startPage(pageNum, 2);
        List<GoodsAndImages> goodsAndImages = goodsDao.selectByListGoodsId(byGoodsTypeId);

        for (GoodsAndImages gi : goodsAndImages) {
            gi.setIntroduction(gi.getIntroduction().replace("</br>", ""));
            //判断map中是否存在key
            if (map.containsKey(goodsType)) {
                List<GoodsAndImages> list = (List<GoodsAndImages>) map.get(goodsType);
                list.add(gi);
            } else {
                List<GoodsAndImages> list2 = new ArrayList<>();
                list2.add(gi);
                map.put(goodsType, list2);
            }
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    @Test
    public void bbb() {
        GoodsVo gv = new GoodsVo();
//        gv.setGoodsType("");
        List<GoodsAndImages> ifGoodsVo = goodsAndImagesDao.findIfGoodsVo(gv);
        for (GoodsAndImages goodsAndImages : ifGoodsVo) {
            System.out.println(goodsAndImages);
        }
    }


    @Test
    public void ccc() {
//        User lilei = userDao.findByUserName("lilei");
//        if (lilei == null) {
//            System.out.println("空");
//        } else {
//            System.out.println("不为空");
//        }
        List<String> s = new ArrayList<>();
        String a = "name=jie&password=root&rePassword=root";
        String[] split = a.split("&");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            for (int j = 1; j < split2.length; j++) {
                s.add(split2[j]);
            }
        }
        System.out.println(s.get(0));
    }

    @Test
    public static int[] sum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        boolean isFound = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] sum2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        boolean isFound = false;
        Map<Integer, Integer> numsMap = new HashMap<>(2);
        for (int temp : nums) {
            numsMap.put(temp, temp);
        }

        for (Map.Entry<Integer,Integer> temp : numsMap.entrySet()) {
            
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = sum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    @Test
    public void orderId(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String date = sdfTime.format(new Date()).toString();
        String replace = date.replace("-", "").replace(" ", "").replace(":", "");
        Long aLong = Long.valueOf(replace);
        System.out.println(aLong);
    }
}
