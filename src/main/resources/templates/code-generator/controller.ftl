package com.yangrd.codegenerator.factory;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
* ${clazzName?cap_first}Controller
*
* @author yangrd
* @date 2019/07/11
*/
@AllArgsConstructor

@RestController
@RequestMapping("/${clazzName?cap_first}")
public class ${clazzName?cap_first}Controller {

    private ${clazzName?cap_first}Service service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ${clazzName?cap_first} ${clazzName}){
        service.save(${clazzName});
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ${meta.idType} id){
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable ${meta.idType} id, @RequestBody ${clazzName?cap_first} ${clazzName}){
        service.updateById(${clazzName},id);
    }

    @GetMapping("/{id}")
    public Demo get(@PathVariable ${meta.idType} id){
        return service.findOne(id);
    }

    @GetMapping
    public Page<${clazzName?cap_first}> findAll(Pageable pageable){
        return service.findAll(null,pageable);
    }
}
