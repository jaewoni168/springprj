@RequestMapping("test2")
public String test2(Model model,
        @RequestParam(value="id", required=false, defaultValue="0") int id,
        @RequestParam(value="name", required=false, defaultValue="nobody") String name) {