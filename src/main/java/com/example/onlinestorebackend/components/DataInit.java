package com.example.onlinestorebackend.components;

import com.example.onlinestorebackend.exceptions.*;
import com.example.onlinestorebackend.models.*;
import com.example.onlinestorebackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.List;

import static com.example.onlinestorebackend.utils.Constants.Security.*;

/**
 *
 * @author Bahadir Tasli
 * @Date 3/21/2023
 */

@Component
public class DataInit {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private OrderLineService orderLineService;
//    @Autowired
//    private OrderService orderService;

    @PostConstruct
    public void init(){
//        initProduct();
//        initUser();
//        initAuthor();
//        initCategory();
//        initSubCategory();
//        initOrder();

    }

    private void initOrder() {
        System.out.println("Starting initializing Order....");

        try {
            User user = userService.findUserByFullName("1");
            List<OrderLine> orderLineList = orderLineService.findActiveOrderLineByUser(user);

            Order order = new Order();
            order.setStatus(Status.ACTIVE);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void initCategory() {
        System.out.println("Starting initializing Category..");
        Category category = new Category();
        category.setName("Sports");

        try {
            Category searchCategory = categoryService.findCategoryByName(category.getName());
            System.out.println("Cannot pre-initialize category: " + category.getName());
        } catch (CategoryNotFoundException e) {
            categoryService.createCategory(category);
        }
    }

    private void initProduct() {
        System.out.println("Starting initializing Product..");

        try {
            SubCategory searchSubCategory = subCategoryService.findSubCategoryByName("ttt");
            Product product = new Product();
            product.setTitle("basketball");
            product.setSubCategory(searchSubCategory);
            product.setDescription("ball");
            product.setInventory(4f);

            try {
                Product searchProduct = productService.findProductByTitle(product.getTitle());
                System.out.println("Cannot pre-initialize product: " + product.getTitle());
            } catch (ProductNotFoundException e) {
                productService.createProduct(product);
            }
        } catch (SubCategoryNotFoundException e) {
            System.out.println("Can not pre-initialize category! Reason : " + e.getLocalizedMessage());
        }
    }


    private void initAuthor() {
        System.out.println("Starting initializing Author..");
        Author authorAdmin = new Author();
        authorAdmin.setFirstName(AUTHOR_ADMIN);
        createAuthor(authorAdmin);

        Author authorUser = new Author();
        authorUser.setFirstName(AUTHOR_USER);
        createAuthor(authorUser);
    }

    private void initUser() {

        System.out.println("Starting initializing User..");

        try {
            Author author = authorService.findAuthorByName(AUTHOR_ADMIN);


            User user = new User();
            user.setFullName("1");
            user.setPassword("1");
            user.setAuthor(author);
            //user.setRole(Role.CUSTOMER);

            try {
                User resultUser = userService.findUserByFullName(user.getFullName());
                System.out.println("Cannot pre-initialize user: " + user.getFullName());
            } catch(UserNotFoundException e) {
                userService.createUser(user);
            }
        } catch (AuthorNotFoundException e) {
            System.out.println("Cannot pre-initialize User! Reason:  " + e.getLocalizedMessage());
        }
    }

    private void createAuthor(Author author) {
        try {
            Author resultAuthor = authorService.findAuthorByName(author.getFirstName());
            System.out.println("Can not pre-initialize author : " + author.getFirstName());
        } catch (AuthorNotFoundException e){
            authorService.createAuthor(author);
        }
    }





    public void initSubCategory() {
        System.out.println("Starting initializing Sub Category..");

        try {
            Category searchCategory = categoryService.findCategoryByName("Sports");

            SubCategory subCategory = new SubCategory();
            subCategory.setName("Laptops");
            subCategory.setCategory(searchCategory);

            try {
                SubCategory searchSubCategory = subCategoryService.findSubCategoryByName(subCategory.getName());
                System.out.println("Cannot pre*initialize sub category: " + subCategory.getName());
            } catch (SubCategoryNotFoundException e) {
                subCategoryService.createSubCategory(subCategory);
            }

            SubCategory subCategory1 = new SubCategory();
            subCategory1.setName("Smartphones");
            subCategory1.setCategory(searchCategory);

            try {
                SubCategory searchSubCategory = subCategoryService.findSubCategoryByName(subCategory1.getName());
                System.out.println("Cannot pre*initialize sub category: " + subCategory1.getName());
            } catch (SubCategoryNotFoundException e) {
                subCategoryService.createSubCategory(subCategory1);
            }


        } catch (CategoryNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

