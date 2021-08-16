package com.soul.exception;


/**
 * @author LingCoder
 * @Description:动态的向DynamicFields添加字段
 * @Date 2020/11/15-15:10
 * 只有你知道如何处理的情况下才捕获异常
 * 吞噬则有害
 * 打印栈轨迹 跟踪异常的行为
 * 所有模型都是错误的 但是有些是能用的
 * 异常说明：1、我的代码会产生这种异常需要你来处理  2、我的代码忽略了这种异常，需要你来处理
 *
 * 使用异常的情况
 *  1、在恰当的级别处理问题
 *  2、解决问题并重新调用产生异常的方法
 *  3、进行少许修补，然后绕过异常发生的地方继续执行
 *  4、用别的数据进行计算，以代替方法预计会返回的值
 *  5、把当前运行环境能做的事情尽量做完，然后把相同的异常重抛到更高层
 *  6、把当前运行环境能做的事情尽量做完，然后把不同的异常抛到更高层
 *  7、终止程序
 *  8、进行简化（异常模式处理问题的时候过于复杂）
 *  9、让类库和程序更安全
 */
class DynamicFieldsException  extends Exception{

}

public class DynamicFields{
        private Object[][] fields;

        public DynamicFields(int initialSize) {
                fields = new Object[initialSize][2];
                for (int i = 0; i < initialSize; i++) {
                        fields[i]= new Object[]{null,null};
                }
        }

        public String toString(){
                StringBuilder result = new StringBuilder();
                for (Object[] field : fields) {
                        result.append(field[0]);
                        result.append(":");
                        result.append(field[1]);
                        result.append("\n");
                }
                return result.toString();
        }

        private int hasField(String id){
                for (int i = 0; i < fields.length; i++) {
                        if(id.equals(fields[i][0])){
                                return i;
                        }
                }
                return -1;
        }

        private int getFieldNumber(String id) throws NoSuchFieldException{
                int fieldNum = hasField(id);
                if(fieldNum == -1)
                        throw new NoSuchFieldException();
                return fieldNum;
        }

        private int makeField(String id){
                for (int i = 0; i < fields.length; i++) {
                        if(fields[i][0] == null){
                                fields[i][0] = id;
                                return i;
                        }
                }
                // 非空字段 直接添加
                Object[][] temp = new Object[fields.length+1][2];
                for (int i = 0; i < fields.length; i++) {
                        temp[i] = fields[i];
                }

                for (int i = fields.length; i < temp.length; i++) {
                       temp[i] = new Object[]{null,null};
                }
                fields = temp;
                return makeField(id);
        }

        public Object getField(String id) throws NoSuchFieldException{
                return fields[getFieldNumber(id)];
        }

        public Object setField(String id,Object value) throws DynamicFieldsException{
                if(value == null){
                        DynamicFieldsException dynamicFieldsException = new DynamicFieldsException();
                        dynamicFieldsException.initCause(new NullPointerException());
                        throw  dynamicFieldsException;
                }
                int fieldNumber = hasField(id);
                if(fieldNumber == -1){
                        fieldNumber = makeField(id);
                }
                Object result = null;

                try {
                        // 获取原来的值
                        result = getField(id);
                } catch (NoSuchFieldException e) {
                       throw new RuntimeException(e);
                }
                fields[fieldNumber][1] = value;
                return result;
        }

        public static void main(String[] args) {
                DynamicFields dynamicFields = new DynamicFields(3);
                System.out.println(dynamicFields);
                System.out.println("================================");
                try {
                        dynamicFields.setField("d","针对d的一个值");
                        dynamicFields.setField("number",66);
                        dynamicFields.setField("number2",99);
                        System.out.println(dynamicFields);
                        System.out.println("================================");

                        dynamicFields.setField("d","针对d的一个新的值");
                        dynamicFields.setField("number3",100);
                        System.out.println(dynamicFields);
                        System.out.println("================================");

                        System.out.printf("getField('d'):%s",dynamicFields.getField("d"));
                        System.out.println("================================");
                        Object d = dynamicFields.setField("d", null);

                } catch (DynamicFieldsException e) {
                        e.printStackTrace();
                } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                }
        }
}
