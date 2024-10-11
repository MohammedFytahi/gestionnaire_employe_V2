package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.repository.impl.ApplicationRepository;
import com.example.gestionaire_employe_v2.service.interf.ApplicationServiceInterface;

public class ApplicationService implements ApplicationServiceInterface {
   private ApplicationRepository applicationRepository ;
   public ApplicationService(){
       this.applicationRepository = new ApplicationRepository();
   }

   @Override
    public void saveApplication(Application application){
       applicationRepository.saveApplication(application);
   }
}
