//package JwtRequestFilter;
//
//@Component
//public class UserJwtRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String email = null;
//        String jwt = null;
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7);
//            email = jwtUtil.extractEmail(jwt);
//        }
//
//        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
//            if (jwtUtil.validateToken(jwt, userDetails)) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
