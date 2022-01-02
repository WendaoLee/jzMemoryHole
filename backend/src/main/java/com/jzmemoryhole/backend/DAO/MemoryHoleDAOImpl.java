package com.jzmemoryhole.backend.DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.jzmemoryhole.backend.Modules.MemoryMail;
import com.jzmemoryhole.backend.Modules.MemoryPeck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemoryHoleDAOImpl {

    static int theRecordNo = 0;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //获取当前树洞总数,返回下一条记录的编号
    public int countHoles(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT COUNT(id) FROM jzmemory.hole");
        Long temp =(Long) list.get(0).get("COUNT(id)");
        int trueNo = temp.intValue();
        MemoryHoleDAOImpl.theRecordNo = trueNo + 1;
        return trueNo;
    }


    //添加一个树洞。它将会同时创建一个对应的回复树洞的表
    public MemoryPeck addMemoryHole(MemoryPeck memoryPeck){
        int temp;
        if(memoryPeck.getId() !=(temp = countHoles()) ){
            memoryPeck.correctId(temp);
        }

        String upRecord = "INSERT INTO `jzmemory`.`hole` (`id`, `emojiInfo`, `text`, `date`, `hash`) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(upRecord,
        new Object[]{memoryPeck.getId(),memoryPeck.getEmojiInfo(),memoryPeck.getDescription(),memoryPeck.getDate(),memoryPeck.getHashCode()});

        //创建树洞回复表
        jdbcTemplate.execute("use jzholemail");
        int hashTablename = memoryPeck.getHashCode();
        String sql = "CREATE TABLE `jzholemail`."+"`"+hashTablename+"` ( `text` LONGTEXT NOT NULL, `date` DATE NOT NULL DEFAULT '1906-01-01',`Img` MEDIUMTEXT NULL,`id` INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (`id`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;";
        jdbcTemplate.execute(sql);

        return memoryPeck;
    }

    //添加一条树洞的回复
    public MemoryMail addMemoryMail(MemoryMail memoryMail,int id){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select hash from jzmemory.hole where id ="+ "'"+id+"'");
        int hash =(int) list.get(0).get("hash");
        String sql = "INSERT INTO `jzholemail`.`"+hash+"`(`text`,`date`,`Img`) VALUES(?, ?, ?);";

        jdbcTemplate.update(sql, new Object[]{memoryMail.getText(),memoryMail.getDate(),memoryMail.getImg()});
        return memoryMail;
    }

    //获取指定树洞的信息
    public List<Map<String,Object>> getOneHole(int id){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select * from jzmemory.hole where id ="+ "'"+id+"'");

        for(Map<String, Object> map : list){

            Set<Entry<String,Object>> entries = map.entrySet();
            if(entries != null){
                Iterator<Entry<String, Object>> iterator = entries.iterator( );
                    while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();

                    System.out.println(key+":"+value);
                    }
             }
        
        }
        return list;
    }

    //获取指定hash值的树洞的所有回复帖
    public List<Map<String,Object>> getMailsByHash(int hash){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select * from jzholemail."+"`"+hash+"`");
        return list;
    }


    public List<Map<String,Object>> getMailsById(int id){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select hash from jzmemory.hole where id ="+ "'"+id+"'");
        int hash =(int) list.get(0).get("hash");
        list = getMailsByHash(hash);
        return list;
    }

    //原先为返回随机4条有序树洞
    //现改为按倒序返回最新5条树洞记录
    public List<Map<String,Object>> getHolesRandomly(){
        //theRecordNo为0表示还没进行初始化
        int getEndNo;
        if(MemoryHoleDAOImpl.theRecordNo == 0){
            getEndNo = countHoles();
        }
        else{
            getEndNo = MemoryHoleDAOImpl.theRecordNo;
        }
    
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select * from jzmemory.hole where id <="+ getEndNo + " order by id desc limit 20");

        return list;
        
    }

    //临时接口，按倒序获取所有树洞记录
    public List<Map<String,Object>> getAll(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("Select * from jzmemory.hole where id > 0");
        return list;
    }

}
