package com.user.profile.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

@Data
@Table(name = "user")
@Entity
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "job_role")
  private String jobRole;

  @Column(name = "user_image", length = 1000)
  private byte[] userImage;

  @Column(name = "company_id")
  private Long companyId;
}
