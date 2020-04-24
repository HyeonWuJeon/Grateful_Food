package com.example.demo.web.Controller;

import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CategoryService;

import com.example.demo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final CategoryService categoryService;

    private final HttpSession httpSession;
    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    private final FoodService foodService;


    /**
     * 모든 카테고리 뿌려준다
     * @return
     */
//    @RequestMapping(value = "/")
//    public String index() {
//        return "index";
//    }

//    @GetMapping("/test")
//    public IndexController index(Model model) {
//
//        return this;
//    }
        /**
         * List 형태반환
         */
//        model.addAttribute("category_name", categoryService.findAllDesc());
//
//
////        CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
////        즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.
//
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분
//
//        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
//            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
//            model.addAttribute("userName", user.getName());
//        }
//
//    }


    /**
     * 치킨 가게
     */

    @GetMapping("/chickin")
    public String postsCheckin(Model model){

        model.addAttribute("Bbq", foodService.findStore(1));
        model.addAttribute("Kfc", foodService.findStore(2));

        return "chickin";
    }

    /**
     * 족발 가게
     */
    @GetMapping("/zokbal")
    public String postsPig(Model model){
        model.addAttribute("HyeonWuZok", foodService.findStore(3));
        model.addAttribute("Gazok", foodService.findStore(4));

        return "zokbal";
    }




    /**
     * 한식가게
     */
    @GetMapping("/korea")
    public String postsKorea(Model model){

        model.addAttribute("Heaven", foodService.findStore(5));
        model.addAttribute("Hell", foodService.findStore(6));

        return "korea";
    }

    /**
     * 피자 가게
     */
    @GetMapping("/pizza")
    public String postsPizza(Model model){

        model.addAttribute("Domino", foodService.findStore(7));
        model.addAttribute("Pizzahut", foodService.findStore(8));

        return "pizza";
    }


    /**
     *
     * @param complete
     * @return
     */

    @GetMapping("/chickin/bbq")
    public String foodBbq(Model model){
        model.addAttribute("bbq", foodService.findOne(1));
        return "bbq";
    }

    @GetMapping("/chickin/kfc")
    public String foodKfc(Model model){

        model.addAttribute("kfc", foodService.findOne(2));
        return "kfc";
    }

    @GetMapping("/zokbal/hyeonwoo")
    public String foodHyeonwoo(Model model){
        model.addAttribute("hyeonwoo", foodService.findOne(3));

        return "hyeonwu";
    }

    @GetMapping("/zookbal/gazok")
    public String foodGazok(Model model){
        model.addAttribute("gazok", foodService.findOne(4));

        return "gazok";
    }

    @GetMapping("/korea/heaven")
    public String foodHeaven(Model model){
        model.addAttribute("heaven", foodService.findOne(5));
        return "heavn";
    }

    @GetMapping("/korea/hell")
    public String foodHell(Model model){
        model.addAttribute("hell", foodService.findOne(6));
        return "hell";
    }




    @GetMapping("/pizza/domino")
    public String foodPizzahut(Model model){
        model.addAttribute("domino", foodService.findOne(7));
        return "domino";
    }

    @GetMapping("/pizza/pizzahut")
    public String foodDomino(Model model){
        model.addAttribute("pizzahut", foodService.findOne(8));
        return "pizzahut";
    }




    @GetMapping("posts/mydata") //내 정보 + 주문목록
    public String postsMyData(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분
        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());

        }
        model.addAttribute("Order", orderRepository.findAll());

        return "mydata-page";
    }





    /**
     *
     * @param 모든댓글
     * 사장 / 고객 모든댓글을보여준다.
     */
    @GetMapping("/posts/comment")
    public String CommentUser(Model model) {

        model.addAttribute("Comment", commentRepository.findAll());
        return "comment";

    }


    //배송을 알리는 관리자 페이지
    @GetMapping("/posts/chairman")
    public String postsChairman() {
        return "chairman";
    }

}