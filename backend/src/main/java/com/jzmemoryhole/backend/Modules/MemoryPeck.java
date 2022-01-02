package com.jzmemoryhole.backend.Modules;

//主题楼
public class MemoryPeck {
    private int id; // 树洞编号
    private String emojiInfo;// 树洞对应的emoji符号
    private String description;
    private String date;
    private int hashcode;// hash映射

    public MemoryPeck(int id, String emojiInfo, String description, String date) {

        // 对于EmojiInfo符合的，准确录入
        // 不符合者，则设置EmojiInfo为⚠
        if (emojiInfo.length() <= 5) {
            this.id = id;
            this.emojiInfo = emojiInfo;
            this.description = description;
            this.date = date;
            this.hashcode = (id + emojiInfo + description).hashCode();
        } else {
            this.id = id;
            this.emojiInfo = "⚠";
            this.description = description;
            this.date = date;
            this.hashcode = (id + emojiInfo + description).hashCode();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getEmojiInfo() {
        return this.emojiInfo;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDate() {
        return this.date;
    }

    public int getHashCode() {
        return this.hashcode;
    }

    public void correctId(int id){
        this.id = id;
    }
}
