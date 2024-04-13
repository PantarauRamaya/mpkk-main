package com.bhrsb.mpkk.adm_menuscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("Duplicates")
@RestController
@RequestMapping("/api")
public class ADM_MENUSCODEController {

    @Autowired
    ADM_MENUSCODEService Menuservice;

    @GetMapping("/getAllMenus")
    public ResponseEntity<List<ADM_MENUSCODE>> getAllMenus() {
        try {
            List<ADM_MENUSCODE> MenuList = new ArrayList<>();
            Menuservice.findAll().forEach(MenuList::add);

            if (MenuList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(MenuList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMenuById/{id}")
    public ResponseEntity<ADM_MENUSCODE> getMenuById(@PathVariable Long id) {
        Optional<ADM_MENUSCODE> MenuObj = Menuservice.findById(id);
        if (MenuObj.isPresent()) {
            return new ResponseEntity<>(MenuObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addMenu")
    public ResponseEntity<ADM_MENUSCODE> addMenu(@RequestBody ADM_MENUSCODE Menu) {
        try {
            ADM_MENUSCODE MenuObj = Menuservice.save(Menu);
            return new ResponseEntity<>(MenuObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateMenu/{id}")
    public ResponseEntity<ADM_MENUSCODE> updateMenu(@PathVariable Long id, @RequestBody ADM_MENUSCODE Menu) {
        try {
            Optional<ADM_MENUSCODE> MenuData = Menuservice.findById(id);
            if (MenuData.isPresent()) {
                ADM_MENUSCODE updatedMenuData = MenuData.get();
                // updatedMenuData.setTitle(Menu.getTitle());
                // updatedMenuData.setAuthor(Menu.getAuthor());

                ADM_MENUSCODE MenuObj = Menuservice.save(updatedMenuData);
                return new ResponseEntity<>(MenuObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteMenuById/{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable Long id) {
        try {
            Menuservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * @DeleteMapping("/deleteAllMenus")
     * public ResponseEntity<HttpStatus> deleteAllMenus() {
     * try {
     * Menuservice.deleteAll();
     * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     * } catch (Exception e) {
     * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

}
