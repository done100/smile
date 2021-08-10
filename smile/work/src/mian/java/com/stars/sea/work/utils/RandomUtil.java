package com.stars.sea.work.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    public static String[] contacts = {"父亲", "母亲", "祖父", "祖母", "外公", "外婆", "其他"};
    public static String[] intentionLevel = {"高意向", "中意向", "低意向", "暂无意向"};
    public static String[] education = {"小学", "初中", "高中", "专科", "本科", "研究生", "其他"};
    public static String[] nation = {"汉族", "壮族", "满族", "回族", "苗族", "维吾尔族", "土家族", "彝族", "蒙古族", "藏族", "布依族","珞巴族","布朗族","其他"};
    public static String[] maritalStatus = {"已婚", "未婚", "离异", "丧偶"};
    /**
     * 获取多个联系人（家长）并且不能重复
     * @param count
     * @return
     */
    public static List<String> getContact(int count) {
        HashSet<String> hashSet = new HashSet<>();
        Random random1 = new Random(System.currentTimeMillis());
        int index = 0;
        while (hashSet.size() < count) {
            index = random1.nextInt(contacts.length - 1);
            hashSet.add(contacts[index]);
        }
        return new ArrayList<>(hashSet);
        //List<String> list = new ArrayList<>();
        // hashSet.forEach(contact -> list.add(contact));
        // return list;
    }
    public static List<String> getIntentionLevel(int count) {
        List<String> list = new ArrayList<>();
        if (count<1) {
            return list;
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(intentionLevel.length-1);
            list.add(intentionLevel[index]);
        }
        return list;
    }
    public static List<String> getEducation(int count) {
        List<String> list = new ArrayList<>();
        if (count<1) {
            return list;
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(education.length-1);
            list.add(education[index]);
        }
        return list;
    }

    /**
     * 随机获取民族
     * @param count
     * @return
     */
    public static List<String> getNation(int count) {
        List<String> list = new ArrayList<>();
        if (count<1) {
            return list;
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(nation.length-1);
            list.add(nation[index]);
        }
        return list;
    }
    /**
     * 随机获取婚姻状况
     * @param count
     * @return
     */
    public static List<String> getMaritalStatus(int count) {
        List<String> list = new ArrayList<>();
        if (count<1) {
            return list;
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(maritalStatus.length-1);
            list.add(maritalStatus[index]);
        }
        return list;
    }
}
