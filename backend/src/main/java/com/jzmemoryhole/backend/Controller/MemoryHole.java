package com.jzmemoryhole.backend.Controller;


import java.util.List;
import java.util.Map;

import com.jzmemoryhole.backend.DAO.MemoryHoleDAOImpl;
import com.jzmemoryhole.backend.Modules.MemoryMail;
import com.jzmemoryhole.backend.Modules.MemoryPeck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//用於JZ记忆树洞的相关接口
//偷懒了，直接全部写在Controller层
@RestController
@CrossOrigin
@RequestMapping("/jz")
public class MemoryHole {
 
    @Autowired
    MemoryHoleDAOImpl memoryHoleDAOImpl = new MemoryHoleDAOImpl();

    //下面两条是添加树洞（主题帖）和树洞信件（回复帖）的接口
    @PostMapping("/MemoryHole")
    public MemoryPeck addMemoryHole(@RequestBody MemoryPeck memoryPeck){
        return memoryHoleDAOImpl.addMemoryHole(memoryPeck);
    }

    @PostMapping("/MemoryMail/id={id}")
    public MemoryMail addMemoryMail(@RequestBody MemoryMail memoryMail,@PathVariable int id){
        return memoryHoleDAOImpl.addMemoryMail(memoryMail, id);
    }

    //此处考虑设置一个常用接口，常用接口是返回常用数据的接口。对于常用数据，考虑后面在常量池中储存而后直接返回，从而降低服务器资源开销

    //获取指定主题帖信息的接口
    @GetMapping("/MemoryHole/id={id}")
    public List<Map<String,Object>> getOneHole(@PathVariable int id){
        return memoryHoleDAOImpl.getOneHole(id);
    }

    //获取指定hash值的主题帖的所有回复的接口
    @GetMapping("/MemoryMail/hash={hash}")
    public List<Map<String,Object>> getMailsByHash(@PathVariable int hash){
        return memoryHoleDAOImpl.getMailsByHash(hash);
    }

    //获取指定id值的主题帖的所有回复的接口
    @GetMapping("/MemoryMail/id={id}")
    public List<Map<String,Object>> getMailsById(@PathVariable int id){
        return memoryHoleDAOImpl.getMailsById(id);
    }

    //获取最新的5条消息
    @GetMapping("/MemoryHole/latest")
    public List<Map<String,Object>> getHolesRandomly(){
        return memoryHoleDAOImpl.getHolesRandomly();   
    }

    @GetMapping("/MemoryHole/all")
    public List<Map<String,Object>> getMethodName() {
        return memoryHoleDAOImpl.getAll();
    }
    


}

