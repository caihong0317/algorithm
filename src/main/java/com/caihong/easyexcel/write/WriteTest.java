package com.caihong.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ImageData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WriteTest {
    public static final String PATH = "D://excel//";
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
//        simpleWrite();
//        excludeOrIncludeWrite();
//        indexWrite();
//        complexHeadWrite();
//        repeatedWrite();
//        converterWrite();
//        imageWrite();
//        widthAndHeightWrite();
//        mergeWrite();
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    // 4种写法没什么区别
    public static void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        String fileName = PATH + "simpleWrite1-" + System.currentTimeMillis() + ".xlsx";
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        // 分页查询数据
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(WriteTest::data);

        // 写法2
        fileName = PATH + "simpleWrite2-" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

        // 写法3:使用 try-with-resources @since 3.1.0
        fileName = PATH + "simpleWrite3-" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        }

        // 写法4: 不使用 try-with-resources
        fileName = PATH + "simpleWrite4-" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // 千万别忘记close 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.close();
            }
        }
    }

    /**
     * 写出或不写出哪些列
     */
    public static void excludeOrIncludeWrite() {
        String fileName = PATH + "excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里需要注意 在使用ExcelProperty注解的使用，如果想不空列则需要加入order字段，而不是index,order会忽略空列，然后继续往后，而index，不会忽略空列，在第几列就是第几列。

        // 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("date");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).excludeColumnFiledNames(excludeColumnFiledNames).sheet("模板")
                .doWrite(data());

        fileName = PATH + "excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> includeColumnFiledNames = new HashSet<String>();
        includeColumnFiledNames.add("date");
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板")
                .doWrite(data());
    }

    /**
     * 指定写入的列
     * <p>1. 创建excel对应的实体对象 参照{@link IndexData}
     * <p>2. 使用{@link ExcelProperty}注解指定写入的列
     * <p>3. 直接写即可
     */
    public static void indexWrite() {
        String fileName = PATH + "indexWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, IndexData.class).sheet("模板").doWrite(data());
    }

    /**
     * 复杂头写入
     * <p>1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>3. 直接写即可
     */
    public static void complexHeadWrite() {
        String fileName = PATH + "complexHeadWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(data());
    }


    public static void repeatedWrite2() {
        String fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            for (int i = 0; i < 5; i++) {
                final int index = i;
                EXECUTOR_SERVICE.submit(() -> {
                    // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                    WriteSheet writeSheet = EasyExcel.writerSheet(index, "模板" + index).build();
                    List<DemoData> data = data();
                    excelWriter.write(data, writeSheet);
                });
            }
        }
    }


    /**
     * 重复多次写入(几种写法没有本质区别）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ComplexHeadData}
     * <p>
     * 2. 使用{@link ExcelProperty}注解指定复杂的头
     * <p>
     * 3. 直接调用二次写入即可
     */
    public static void repeatedWrite() {
        // 方法1.1: 如果写到同一个sheet 使用 try-with-resources @since 3.1.0
        String fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            for (int i = 0; i < 1; i++) {
                final int index = i;
                EXECUTOR_SERVICE.submit(() -> {
                    try {
                        // 这里注意 如果同一个sheet只要创建一次
                        WriteSheet writeSheet = EasyExcel.writerSheet(index, "模板" + index).build();
                        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
                        for (int j = 0; j < 2; j++) {
                            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                            List<DemoData> data = data();
                            excelWriter.write(data, writeSheet);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            EXECUTOR_SERVICE.shutdown();

//            try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
//                for (int i = 0; i < 1; i++) {
//                    // 这里注意 如果同一个sheet只要创建一次
//                    WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板"+i).build();
//                    // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
//                    for (int j = 0; j < 5; j++) {
//                        // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                        List<DemoData> data = data();
//                        excelWriter.write(data, writeSheet);
//                    }
//                }
//                EXECUTOR_SERVICE.shutdown();

            System.out.println("ok");
        }

//        // 方法1.2: 如果写到同一个sheet 不使用 try-with-resources
//        fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        ExcelWriter writer = null;
//        try {
//            // 这里 需要指定写用哪个class去写
//            writer = EasyExcel.write(fileName, DemoData.class).build();
//            // 这里注意 如果同一个sheet只要创建一次
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
//            for (int i = 0; i < 5; i++) {
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                List<DemoData> data = data();
//                writer.write(data, writeSheet);
//            }
//        } finally {
//            // 千万别忘记close 会帮忙关闭流
//            if (writer != null) {
//                writer.close();
//            }
//        }
//
//        // 方法2.1: 如果写到不同的sheet 同一个对象 使用 try-with-resources @since 3.1.0
//        fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 指定文件
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//            for (int i = 0; i < 5; i++) {
//                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
//                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                List<DemoData> data = data();
//                excelWriter.write(data, writeSheet);
//            }
//        }
//
//        // 方法2.2: 如果写到不同的sheet 同一个对象 不使用 try-with-resources
//        fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        try {
//            // 这里 指定文件
//            writer = EasyExcel.write(fileName, DemoData.class).build();
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//            for (int i = 0; i < 5; i++) {
//                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
//                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                List<DemoData> data = data();
//                writer.write(data, writeSheet);
//            }
//        } finally {
//            // 千万别忘记close 会帮忙关闭流
//            if (writer != null) {
//                writer.close();
//            }
//        }
//
//        // 方法3.1 如果写到不同的sheet 不同的对象 使用 try-with-resources @since 3.1.0
//        fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 指定文件
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName).build()) {
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//            for (int i = 0; i < 5; i++) {
//                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class
//                // 实际上可以一直变
//                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(DemoData.class).build();
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                List<DemoData> data = data();
//                excelWriter.write(data, writeSheet);
//            }
//        }
//
//        // 方法3.2 如果写到不同的sheet 不同的对象 不使用 try-with-resources
//        fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        try {
//            // 这里 指定文件
//            writer = EasyExcel.write(fileName).build();
//            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//            for (int i = 0; i < 5; i++) {
//                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class
//                // 实际上可以一直变
//                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(DemoData.class).build();
//                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//                List<DemoData> data = data();
//                writer.write(data, writeSheet);
//            }
//        } finally {
//            // 千万别忘记close 会帮忙关闭流
//            if (writer != null) {
//                writer.close();
//            }
//        }
    }

    /**
     * 日期、数字或者自定义格式转换
     * <p>1. 创建excel对应的实体对象 参照{@link ConverterData}
     * <p>2. 使用{@link ExcelProperty}配合使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     * <p>3. 直接写即可
     */
    public static void converterWrite() {
        String fileName = PATH + "converterWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(data());
    }

    /**
     * 图片导出
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ImageDemoData}
     * <p>
     * 2. 直接写即可
     */
    public static void imageWrite() throws Exception {
        String fileName = PATH + "imageWrite" + System.currentTimeMillis() + ".xlsx";

        String imagePath = PATH + File.separator + "4.jpg";
        try (InputStream inputStream = FileUtils.openInputStream(new File(imagePath))) {
            List<ImageDemoData> list = ListUtils.newArrayList();
            ImageDemoData imageDemoData = new ImageDemoData();
            list.add(imageDemoData);
            // 放入五种类型的图片 实际使用只要选一种即可
//            imageDemoData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));
//            imageDemoData.setFile(new File(imagePath));
            imageDemoData.setFilePath(imagePath);
//            imageDemoData.setInputStream(inputStream);
//            imageDemoData.setUrl(new URL(
//                    "https://raw.githubusercontent.com/alibaba/easyexcel/master/src/test/resources/converter/img.jpg"));

            // 这里演示
            // 需要额外放入文字
            // 而且需要放入2个图片
            // 第一个图片靠左
            // 第二个靠右 而且要额外的占用他后面的单元格
            WriteCellData<Void> writeCellData = new WriteCellData<>();
            imageDemoData.setWriteCellDataFile(writeCellData);
            // 这里可以设置为 EMPTY 则代表不需要其他数据了
            writeCellData.setType(CellDataTypeEnum.STRING);
            writeCellData.setStringValue("额外的放一些文字");

            // 可以放入多个图片
            List<ImageData> imageDataList = new ArrayList<>();
            ImageData imageData = new ImageData();
            imageDataList.add(imageData);
            writeCellData.setImageDataList(imageDataList);
            // 放入2进制图片
            imageData.setImage(FileUtils.readFileToByteArray(new File(imagePath)));
            // 图片类型
            imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
            // 上 右 下 左 需要留空
            // 这个类似于 css 的 margin
            // 这里实测 不能设置太大 超过单元格原始大小后 打开会提示修复。暂时未找到很好的解法。
            imageData.setTop(5);
            imageData.setRight(40);
            imageData.setBottom(5);
            imageData.setLeft(5);

            // 放入第二个图片
            imageData = new ImageData();
            imageDataList.add(imageData);
            writeCellData.setImageDataList(imageDataList);
            imageData.setImage(FileUtils.readFileToByteArray(new File(imagePath)));
            imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
            imageData.setTop(5);
            imageData.setRight(5);
            imageData.setBottom(5);
            imageData.setLeft(50);
            // 设置图片的位置 假设 现在目标 是 覆盖 当前单元格 和当前单元格右边的单元格
            // 起点相对于当前单元格为0 当然可以不写
            imageData.setRelativeFirstRowIndex(0);
            imageData.setRelativeFirstColumnIndex(0);
            imageData.setRelativeLastRowIndex(0);
            // 前面3个可以不写  下面这个需要写 也就是 结尾 需要相对当前单元格 往右移动一格
            // 也就是说 这个图片会覆盖当前单元格和 后面的那一格
            imageData.setRelativeLastColumnIndex(1);

            // 写入数据
            EasyExcel.write(fileName, ImageDemoData.class).sheet().doWrite(list);
        }
    }

    /**
     * 列宽、行高
     * <p>1. 创建excel对应的实体对象 参照{@link WidthAndHeightData}
     * <p>2. 使用注解{@link ColumnWidth}、{@link HeadRowHeight}、{@link ContentRowHeight}指定宽度或高度
     * <p>3. 直接写即可
     */
    public static void widthAndHeightWrite() {
        String fileName = PATH + "widthAndHeightWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, WidthAndHeightData.class).sheet("模板").doWrite(data());
    }

    /**
     * 合并单元格
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData} {@link DemoMergeData}
     * <p>
     * 2. 创建一个merge策略 并注册
     * <p>
     * 3. 直接写即可
     *
     * @since 2.2.0-beta1
     */
    public static void mergeWrite() {
        // 方法1 注解
        String fileName = PATH + "mergeWrite1-" + System.currentTimeMillis() + ".xlsx";
        // 在DemoStyleData里面加上ContentLoopMerge注解
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoMergeData.class).sheet("模板").doWrite(data());

        // 方法2 自定义合并单元格策略
        fileName = PATH + "mergeWrite2-" + System.currentTimeMillis() + ".xlsx";
        // 每隔2行会合并 把eachColumn 设置成 3 也就是我们数据的长度，所以就第一列会合并。当然其他合并策略也可以自己写
        LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
        OnceAbsoluteMergeStrategy absoluteMergeStrategy = new OnceAbsoluteMergeStrategy(1, 2, 1, 2);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(loopMergeStrategy)
                .registerWriteHandler(absoluteMergeStrategy).sheet("模板").doWrite(data());
    }

    /**
     * 动态头，实时生成头写入
     * <p>
     * 思路是这样子的，先创建List<String>头格式的sheet仅仅写入头,然后通过table 不写入头的方式 去写入数据
     *
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 然后写入table即可
     */
    @Test
    public void dynamicHeadWrite() {
        String fileName = PATH + "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(dynamicHead()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(data());
    }

    private List<List<String>> dynamicHead() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    /**
     * 不创建对象的写
     */
    @Test
    public void noModelWrite() {
        // 写法1
        String fileName = PATH + "noModelWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName).head(dynamicHead()).sheet("模板").doWrite(dataList());
    }

    private List<List<Object>> dataList() {
        List<List<Object>> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Object> data = ListUtils.newArrayList();
            data.add("字符串" + i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }
}
